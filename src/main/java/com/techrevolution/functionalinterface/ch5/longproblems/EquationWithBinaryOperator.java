package com.techrevolution.functionalinterface.ch5.longproblems;

import java.util.function.DoubleBinaryOperator;

public class EquationWithBinaryOperator {
    public static void main(String[] args) {
        // 5*(2x+3y)/2 , x=6 , y=3
        DoubleBinaryOperator intBinaryOperator = (left, right) -> (5 * (2 * left + 3 * right)) / 2;
        System.out.println("Final Equation ans is:--" + intBinaryOperator.applyAsDouble(6, 3));
    }
}
