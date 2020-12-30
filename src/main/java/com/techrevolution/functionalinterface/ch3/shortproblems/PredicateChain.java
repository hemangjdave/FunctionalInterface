package com.techrevolution.functionalinterface.ch3.shortproblems;

import java.util.function.IntPredicate;

public class PredicateChain {
    public static void main(String[] args) {
        //NOT(x < 100 OR x is odd) AND x > 20
        IntPredicate lessThan100 = integer -> integer < 100;
        IntPredicate oddPredicate = integer -> integer % 2 != 0;
        IntPredicate greaterThan20 = integer -> integer > 20;
        IntPredicate notPredicate = lessThan100.or(oddPredicate).negate();
        IntPredicate finalPredicate = notPredicate.and(greaterThan20);
        System.out.println(finalPredicate.test(102));
    }
}
