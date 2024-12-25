package com.taotao.application.test.java.synthetic;

public class MethodDemo {

    class MethodInner {
        private String innerName;
    }

    public void setInnerName(String name) {
        new MethodInner().innerName = name;
    }

    public String getInnerName() {
        return new MethodInner().innerName;
    }
}
