/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oal.rt.parser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import org.apache.skywalking.oal.rt.util.ClassMethodUtil;
import org.apache.skywalking.oap.server.core.analysis.metrics.Metrics;
import org.apache.skywalking.oap.server.core.analysis.metrics.annotation.Arg;
import org.apache.skywalking.oap.server.core.analysis.metrics.annotation.ConstOne;
import org.apache.skywalking.oap.server.core.analysis.metrics.annotation.Entrance;
import org.apache.skywalking.oap.server.core.analysis.metrics.annotation.SourceFrom;
import org.apache.skywalking.oap.server.core.storage.annotation.Column;

import static java.util.Objects.isNull;

/**
 * 深度分析
 */
public class DeepAnalysis {
    public AnalysisResult analysis(AnalysisResult result) {
        // 1. Set sub package name by source.metrics
        // 通过 source.metrics 设置子包名
        result.setPackageName(result.getSourceName().toLowerCase());
        // 根据AnalysisResult中getAggregationFuncStmt中getAggregationFunctionName()的值，到MetricsHolder找对应的Metrics类
        Class<? extends Metrics> metricsClass = MetricsHolder.find(result.getAggregationFunctionName());
        String metricsClassSimpleName = metricsClass.getSimpleName();

        result.setMetricsClassName(metricsClassSimpleName);

        // Optional for filter
        // 过滤器可选
        List<ConditionExpression> expressions = result.getFilterExpressionsParserResult();
        if (expressions != null && expressions.size() > 0) {
            for (ConditionExpression expression : expressions) {
                final FilterMatchers.MatcherInfo matcherInfo = FilterMatchers.INSTANCE.find(expression.getExpressionType());

                final String getter = matcherInfo.isBooleanType()
                    ? ClassMethodUtil.toIsMethod(expression.getAttributes())
                    : ClassMethodUtil.toGetMethod(expression.getAttributes());

                final Expression filterExpression = new Expression();
                filterExpression.setExpressionObject(matcherInfo.getMatcher().getName());
                filterExpression.setLeft("source." + getter + "()");
                filterExpression.setRight(expression.getValue());
                result.addFilterExpressions(filterExpression);
            }
        }

        // 3. Find Entrance method of this metrics
        // 查找此指标的 Entrance 方法
        Class<?> c = metricsClass;
        // 这里时给循环打上标签、当后续需要跳出循环时，知道使用那个标签可以跳出
        Method entranceMethod = null;
        SearchEntrance:
        // 这里的metricsClass不是一个Object
        while (!c.equals(Object.class)) {
            // 遍历metricsClass中的每一个方法
            for (Method method : c.getMethods()) {
                // 获取到一个带有@Entrance注解的方法
                Entrance annotation = method.getAnnotation(Entrance.class);
                if (annotation != null) {
                    entranceMethod = method;
                    break SearchEntrance;
                }
            }
            // 如果子类找不到 向父类中寻找
            c = c.getSuperclass();
        }
        if (entranceMethod == null) {
            throw new IllegalArgumentException("Can't find Entrance method in class: " + metricsClass.getName());
        }
        EntryMethod entryMethod = new EntryMethod();
        result.setEntryMethod(entryMethod);
        // 将 entranceMethod 对象放入 AnalysisResult的entryMethod的属性中
        entryMethod.setMethodName(entranceMethod.getName());

        // 4. Use parameter's annotation of entrance method to generate aggregation entrance.
        // 遍历 带有@Entrance方法的所有参数
        for (Parameter parameter : entranceMethod.getParameters()) {
            // 参数类型
            Class<?> parameterType = parameter.getType();
            // 参数注解
            Annotation[] parameterAnnotations = parameter.getAnnotations();
            if (parameterAnnotations == null || parameterAnnotations.length == 0) {
                throw new IllegalArgumentException(
                    "Entrance method:" + entranceMethod + " doesn't include the annotation.");
            }
            // 当前参数的注解
            Annotation annotation = parameterAnnotations[0];
            if (annotation instanceof SourceFrom) {
                // @SourceFrom
                entryMethod.addArg(
                    parameterType, "source." + ClassMethodUtil.toGetMethod(result.getSourceAttribute()) + "()");
            } else if (annotation instanceof ConstOne) {
                // @ConstOne
                entryMethod.addArg(parameterType, "1");
            } else if (annotation instanceof org.apache.skywalking.oap.server.core.analysis.metrics.annotation.Expression) {
                // @Expression
                if (isNull(result.getFuncConditionExpressions()) || result.getFuncConditionExpressions().isEmpty()) {
                    throw new IllegalArgumentException("Entrance method:" + entranceMethod + " argument can't find funcParamExpression.");
                } else {
                    ConditionExpression expression = result.getNextFuncConditionExpression();
                    final FilterMatchers.MatcherInfo matcherInfo = FilterMatchers.INSTANCE.find(expression.getExpressionType());

                    final String getter = matcherInfo.isBooleanType()
                        ? ClassMethodUtil.toIsMethod(expression.getAttributes())
                        : ClassMethodUtil.toGetMethod(expression.getAttributes());

                    final Expression argExpression = new Expression();
                    argExpression.setRight(expression.getValue());
                    argExpression.setExpressionObject(matcherInfo.getMatcher().getName());
                    argExpression.setLeft("source." + getter + "()");

                    entryMethod.addArg(argExpression);
                }
            } else if (annotation instanceof Arg) {
                // Arg
                entryMethod.addArg(parameterType, result.getNextFuncArg());
            } else {
                throw new IllegalArgumentException(
                    "Entrance method:" + entranceMethod + " doesn't the expected annotation.");
            }
        }

        // 5. Get all column declared in MetricsHolder class.
        c = metricsClass;
        while (!c.equals(Object.class)) {
            // 遍历XxxMetrics 中所有的属性字段
            for (Field field : c.getDeclaredFields()) {
                // 获取在 MetricsHolder 类中 @Column的列
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    //  设置字段相关信息设置到 AnalysisResult的persistentField中
                    result.addPersistentField(
                            field.getName(),
                            column.columnName(),
                            field.getType());
                }
            }
            c = c.getSuperclass();
        }

        // 6. Based on Source, generate default columns
        // 基于 Source，生成默认列
        List<SourceColumn> columns = SourceColumnsFactory.getColumns(result.getSourceName());
        result.setFieldsFromSource(columns);

        result.generateSerializeFields();

        return result;
    }

}
