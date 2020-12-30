package com.techrevolution.functionalinterface.ch3.shortproblems;

import java.util.function.Predicate;

public class CheckDigitInStringPredicate {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = s -> s.matches("[0-9]+");
        System.out.println(stringPredicate.test("Hemang"));
        System.out.println(stringPredicate.test("Hemang@123"));
        System.out.println(stringPredicate.test("0123456789"));
    }
}
