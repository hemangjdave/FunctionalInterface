package com.techrevolution.functionalinterface.ch3.shortproblems;

import java.util.function.Predicate;

public class OverridePredicate {
    public static void main(String[] args) {
        Predicate<String> stringPredicate1 = str -> str.length() > 4;
        Predicate<String> stringPredicate2 = str -> str.charAt(0) == 'a';
        System.out.println(stringPredicate1.and(stringPredicate2).test("alpha"));
        nullSafePredicate();
    }

    public static void nullSafePredicate() {
        Predicate<String> stringPredicate = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.charAt(0) == 'a';
            }

            @Override
            public Predicate<String> and(Predicate<? super String> other) {
//                Predicate<String> nullSafePredicate = str -> str == null ? false : test(str) && other.test(str);
                return str -> str != null && test(str) && other.test(str);
            }
        };
        System.out.println(stringPredicate.and(s -> s.length() > 4).test("alpha"));
    }
}
