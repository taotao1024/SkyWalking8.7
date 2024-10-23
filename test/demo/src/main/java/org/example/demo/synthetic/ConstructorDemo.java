package org.example.demo.synthetic;

public class ConstructorDemo {
    public ConstructorInner inner = new ConstructorInner();

    class ConstructorInner {
        private ConstructorInner() {
        }
    }
}
