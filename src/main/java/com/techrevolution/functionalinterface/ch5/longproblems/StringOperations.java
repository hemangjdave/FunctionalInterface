package com.techrevolution.functionalinterface.ch5.longproblems;

import java.util.function.UnaryOperator;

public class StringOperations {
    public static void main(String[] args) {
        String string = "The fault lies not from our stars";
        UnaryOperator<String> firstOperator = s -> s.concat(" but from ourselves");
        UnaryOperator<String> secondOperator = s -> s.replace("from", "in");
        UnaryOperator<String> thirdOperator = String::toUpperCase;
        System.out.println(firstOperator.apply(string));
        System.out.println(secondOperator.apply(string));
        System.out.println(thirdOperator.apply(string));
    }
}
