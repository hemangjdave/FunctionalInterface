package com.techrevolution.functionalinterface.ch3.shortproblems;

import java.util.function.BiPredicate;

public class BiPredicateMain {
    public static void main(String[] args) {
        //NOT(x > 2 AND y < x)
        BiPredicate<Integer, Integer> biPredicate = (integer, integer2) -> integer > 2 && integer2 < integer;
        System.out.println(biPredicate.negate().test(5, 3));
    }
}
