package com.taotao.application.test.java.nbac;

/**
 * JDK11 以后的版本 引入Nbac修复方法的二义性
 */
public class MainNbac {
    public static void main(String[] args) throws Exception {
        new Outer().outerPublic();
        // Outer.Inner.class.getNestHost().getName() 嵌套宿主
        // Outer.Inner.class.getNestMembers() 嵌套宿主
    }
}