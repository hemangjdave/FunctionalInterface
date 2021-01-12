package com.techrevolution.functionalinterface.ch6.shortproblems;

import java.util.function.IntConsumer;

public class ConsumerChaining {
    private static int anInt = 0;

    public static void main(String[] args) {
        IntConsumer intialConsumer = value -> anInt = value;
        IntConsumer addConsumer = value -> anInt += value;
        IntConsumer multiplyConsumer = value -> anInt *= value;
        IntConsumer printConsumer = value -> System.out.println(anInt);
        intialConsumer.accept(5);
        addConsumer.accept(4);
        multiplyConsumer.andThen(printConsumer).accept(7);
    }
}
