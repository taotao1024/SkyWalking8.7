package com.demo.java.nbac;

import java.lang.reflect.Method;

public class Outer {
    public void outerPublic() throws Exception {
     // new Inner().reflectOuter(new Outer()); // JDK1.8 失败
        new Inner().innerPublic(); // 成功
    }

    private void outerPrivate() {

    }

    /**
     * 内部类中存在 同一个方法不同调用方式 呈现不同调用结果·
     * 如果调用外部类的一个 private 方法：
     *  1、直接调用 -> 不报错
     *  2、反射调用 -> 报错   JDK11中 引入Nbac 消除了二义性
     */
    class Inner {
        public void innerPublic() {
            outerPrivate();
        }

        public void reflectOuter(Outer outer) throws Exception {
            Method method = outer.getClass().getDeclaredMethod("outerPrivate");
            method.invoke(outer);
        }
    }
}
