package com.demo.java.synthetic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * JDK11 之前的版本
 * <p>
 * Synthetic 关键字
 * 合成的，由Java 编译器在编译阶段自动生成的[构造]
 * JLS:所有存在于字节码文件中，但是不存在于源码文件中的[构造]，都应该被 Synthetic 关键字标注
 * [构造] => Constructs => Field、Method、Constructor
 * <p>
 * <p>
 * java 编译器自动帮我们做了var that = this 的操作
 */
public class MainDemo {
    public static void main(String[] args) {
        fileIdDemo();
        MethodDemo();
        ConstructorDemo();
    }

    private static void fileIdDemo() {
        Field[] declaredFieldInner = FileIdDemo.FileIdDemoInner.class.getDeclaredFields();
        for (Field field : declaredFieldInner) {
            System.out.println(field.getName() + " # " + field.isSynthetic());
        }

    }

    private static void MethodDemo() {
        Method[] declaredFields2 = MethodDemo.MethodInner.class.getDeclaredMethods();
        for (Method method : declaredFields2) {
            System.out.println(method.getName() + " # " + method.isSynthetic());
        }
    }

    private static void ConstructorDemo() {
        Constructor<?>[] constructor = ConstructorDemo.ConstructorInner.class.getDeclaredConstructors();
        for (Constructor<?> field : constructor) {
            String item = String.format("%s # %s # %s # %s",
                    field.getName(),
                    field.isSynthetic(),
                    Modifier.toString(field.getModifiers()), // 修饰符
                    field.getModifiers()); // 编号 4096 表示 Synthetic
            System.out.println(item);
        }
    }
}
