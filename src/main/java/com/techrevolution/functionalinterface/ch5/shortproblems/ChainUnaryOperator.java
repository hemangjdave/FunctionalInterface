package com.techrevolution.functionalinterface.ch5.shortproblems;

import java.util.function.IntUnaryOperator;

public class ChainUnaryOperator {
    public static void main(String[] args) {
        // -4 * (x+2)
        // 6 --> -32
        // -4 --> 8
        IntUnaryOperator intUnaryOperator1 = value -> value + 2;
        IntUnaryOperator intUnaryOperator2 = value -> value * -4;
        System.out.println(intUnaryOperator1.andThen(intUnaryOperator2).applyAsInt(6));
        System.out.println(intUnaryOperator1.andThen(intUnaryOperator2).applyAsInt(-4));
    }
}
