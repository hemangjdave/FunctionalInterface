package com.techrevolution.functionalinterface.ch5.shortproblems;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        BinaryOperator<A> binaryOperator = (a1, a2) -> new A(a1.x + a2.x, a1.y - a2.y);
        var t = new A(5, 123.45);
        var u = new A(6, 23.45);
        var apply = binaryOperator.apply(t, u);
        System.out.println(apply);
    }

    static class A {
        int x;
        double y;

        public A(int x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "A{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
