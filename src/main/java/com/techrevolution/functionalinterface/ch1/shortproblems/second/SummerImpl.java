package com.techrevolution.functionalinterface.ch1.shortproblems.second;

public class SummerImpl {
    public static void main(String[] args) {
        Summer<Integer> integerSummer = (int1, int2) -> int1 + int2;
        Summer<Double> doubleSummer = (value1, value2) -> value1 + value2;
        Summer<Long> longSummer = ((value1, value2) -> value1 + value2);
        System.out.println(integerSummer.add(1, 2));
        System.out.println(doubleSummer.add(3.14, 3.14));
        System.out.println(longSummer.add(1L, 2L));
    }
}
