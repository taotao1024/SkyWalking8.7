// Generated from org\apache\skywalking\oal\rt\grammar\OALParser.g4 by ANTLR 4.7.1
package org.apache.skywalking.oal.rt.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OALParser}.
 */
public interface OALParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OALParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(OALParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(OALParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#aggregationStatement}.
	 * @param ctx the parse tree
	 */
	void enterAggregationStatement(OALParser.AggregationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#aggregationStatement}.
	 * @param ctx the parse tree
	 */
	void exitAggregationStatement(OALParser.AggregationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#disableStatement}.
	 * @param ctx the parse tree
	 */
	void enterDisableStatement(OALParser.DisableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#disableStatement}.
	 * @param ctx the parse tree
	 */
	void exitDisableStatement(OALParser.DisableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#metricStatement}.
	 * @param ctx the parse tree
	 */
	void enterMetricStatement(OALParser.MetricStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#metricStatement}.
	 * @param ctx the parse tree
	 */
	void exitMetricStatement(OALParser.MetricStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void enterFilterStatement(OALParser.FilterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#filterStatement}.
	 * @param ctx the parse tree
	 */
	void exitFilterStatement(OALParser.FilterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#filterExpression}.
	 * @param ctx the parse tree
	 */
	void enterFilterExpression(OALParser.FilterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#filterExpression}.
	 * @param ctx the parse tree
	 */
	void exitFilterExpression(OALParser.FilterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(OALParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(OALParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#disableSource}.
	 * @param ctx the parse tree
	 */
	void enterDisableSource(OALParser.DisableSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#disableSource}.
	 * @param ctx the parse tree
	 */
	void exitDisableSource(OALParser.DisableSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#sourceAttributeStmt}.
	 * @param ctx the parse tree
	 */
	void enterSourceAttributeStmt(OALParser.SourceAttributeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#sourceAttributeStmt}.
	 * @param ctx the parse tree
	 */
	void exitSourceAttributeStmt(OALParser.SourceAttributeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#sourceAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSourceAttribute(OALParser.SourceAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#sourceAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSourceAttribute(OALParser.SourceAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(OALParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(OALParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunction(OALParser.AggregateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunction(OALParser.AggregateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(OALParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(OALParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#funcParamExpression}.
	 * @param ctx the parse tree
	 */
	void enterFuncParamExpression(OALParser.FuncParamExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#funcParamExpression}.
	 * @param ctx the parse tree
	 */
	void exitFuncParamExpression(OALParser.FuncParamExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(OALParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(OALParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(OALParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(OALParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#containMatch}.
	 * @param ctx the parse tree
	 */
	void enterContainMatch(OALParser.ContainMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#containMatch}.
	 * @param ctx the parse tree
	 */
	void exitContainMatch(OALParser.ContainMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#notContainMatch}.
	 * @param ctx the parse tree
	 */
	void enterNotContainMatch(OALParser.NotContainMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#notContainMatch}.
	 * @param ctx the parse tree
	 */
	void exitNotContainMatch(OALParser.NotContainMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#booleanMatch}.
	 * @param ctx the parse tree
	 */
	void enterBooleanMatch(OALParser.BooleanMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#booleanMatch}.
	 * @param ctx the parse tree
	 */
	void exitBooleanMatch(OALParser.BooleanMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#stringMatch}.
	 * @param ctx the parse tree
	 */
	void enterStringMatch(OALParser.StringMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#stringMatch}.
	 * @param ctx the parse tree
	 */
	void exitStringMatch(OALParser.StringMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#greaterMatch}.
	 * @param ctx the parse tree
	 */
	void enterGreaterMatch(OALParser.GreaterMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#greaterMatch}.
	 * @param ctx the parse tree
	 */
	void exitGreaterMatch(OALParser.GreaterMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#lessMatch}.
	 * @param ctx the parse tree
	 */
	void enterLessMatch(OALParser.LessMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#lessMatch}.
	 * @param ctx the parse tree
	 */
	void exitLessMatch(OALParser.LessMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#greaterEqualMatch}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqualMatch(OALParser.GreaterEqualMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#greaterEqualMatch}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqualMatch(OALParser.GreaterEqualMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#lessEqualMatch}.
	 * @param ctx the parse tree
	 */
	void enterLessEqualMatch(OALParser.LessEqualMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#lessEqualMatch}.
	 * @param ctx the parse tree
	 */
	void exitLessEqualMatch(OALParser.LessEqualMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#booleanNotEqualMatch}.
	 * @param ctx the parse tree
	 */
	void enterBooleanNotEqualMatch(OALParser.BooleanNotEqualMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#booleanNotEqualMatch}.
	 * @param ctx the parse tree
	 */
	void exitBooleanNotEqualMatch(OALParser.BooleanNotEqualMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#notEqualMatch}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualMatch(OALParser.NotEqualMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#notEqualMatch}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualMatch(OALParser.NotEqualMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#likeMatch}.
	 * @param ctx the parse tree
	 */
	void enterLikeMatch(OALParser.LikeMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#likeMatch}.
	 * @param ctx the parse tree
	 */
	void exitLikeMatch(OALParser.LikeMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#inMatch}.
	 * @param ctx the parse tree
	 */
	void enterInMatch(OALParser.InMatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#inMatch}.
	 * @param ctx the parse tree
	 */
	void exitInMatch(OALParser.InMatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#multiConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterMultiConditionValue(OALParser.MultiConditionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#multiConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitMultiConditionValue(OALParser.MultiConditionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#conditionAttributeStmt}.
	 * @param ctx the parse tree
	 */
	void enterConditionAttributeStmt(OALParser.ConditionAttributeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#conditionAttributeStmt}.
	 * @param ctx the parse tree
	 */
	void exitConditionAttributeStmt(OALParser.ConditionAttributeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#conditionAttribute}.
	 * @param ctx the parse tree
	 */
	void enterConditionAttribute(OALParser.ConditionAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#conditionAttribute}.
	 * @param ctx the parse tree
	 */
	void exitConditionAttribute(OALParser.ConditionAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#booleanConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanConditionValue(OALParser.BooleanConditionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#booleanConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanConditionValue(OALParser.BooleanConditionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#stringConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterStringConditionValue(OALParser.StringConditionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#stringConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitStringConditionValue(OALParser.StringConditionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#enumConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterEnumConditionValue(OALParser.EnumConditionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#enumConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitEnumConditionValue(OALParser.EnumConditionValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#numberConditionValue}.
	 * @param ctx the parse tree
	 */
	void enterNumberConditionValue(OALParser.NumberConditionValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#numberConditionValue}.
	 * @param ctx the parse tree
	 */
	void exitNumberConditionValue(OALParser.NumberConditionValueContext ctx);
}