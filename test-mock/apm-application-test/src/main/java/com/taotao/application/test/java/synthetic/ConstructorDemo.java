package com.taotao.application.test.java.synthetic;

public class ConstructorDemo {
    public ConstructorInner inner = new ConstructorInner();

    class ConstructorInner {
        private ConstructorInner() {
        }
    }
}
