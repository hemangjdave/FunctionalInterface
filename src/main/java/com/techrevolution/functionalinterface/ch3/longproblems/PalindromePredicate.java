package com.techrevolution.functionalinterface.ch3.longproblems;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class PalindromePredicate {
    public static void main(String[] args) {
        //kayak
        //hemangnameh
        //ahemannameha
        Predicate<String> stringPredicate = PalindromePredicate::isPalindrome;
        System.out.println("kayak is palindrome :--" + stringPredicate.test("kayak"));
        System.out.println("hemangnameh is palindrome :--" + stringPredicate.test("hemangnameh"));
        System.out.println("ahemannameha is palindrome :--" + stringPredicate.test("ahemannameha"));
        System.out.println("javaTheLanguage is palindrome :--" + stringPredicate.test("javaTheLanguage"));
        System.out.println("null is palindrome :--" + stringPredicate.test(null));
        System.out.println("A is palindrome :--" + stringPredicate.test("A"));
        System.out.println("AB is palindrome :--" + stringPredicate.test("AB"));
        System.out.println("ABA is palindrome :--" + stringPredicate.test("ABA"));
    }

    private static boolean isPalindrome(String string) {
        ToIntFunction<String> toIntFunction = String::length;
        if (string == null || toIntFunction.applyAsInt(string) == 2) return false;
        if (toIntFunction.applyAsInt(string) == 1) return true;
        var noOfCycle = getNoOfCycles(string);
        var endingPosition = string.length() - 1;
        for (var index = 0; index < noOfCycle; index++) {
            var firstChar = string.charAt(index);
            var lastChar = string.charAt(endingPosition);
            if (firstChar != lastChar) {
                return false;
            }
            endingPosition--;
        }
        return true;
    }

    private static int getNoOfCycles(String str) {
        ToIntFunction<String> evenOddFunction = s -> {
            var length = s.length();
            return length % 2 == 0 ? length / 2 : (length / 2) + 1;
        };
        return evenOddFunction.applyAsInt(str);
    }
}
