package com.techrevolution.functionalinterface.ch5.shortproblems;

import java.util.function.UnaryOperator;

public class OddPisitionCharToString {
    public static void main(String[] args) {
        // Hemang --> Hmn
        // abcdefghijklmnopqrstuvwxyz --> acegikmoqsuwy
        UnaryOperator<String> stringUnaryOperator = s -> {
            var length = s.length();
            StringBuilder returnString = new StringBuilder();
            for (var i = 0; i < length; i += 2) {
                returnString.append(s.charAt(i));
            }
            return returnString.toString();
        };
        System.out.println(stringUnaryOperator.apply("Hemang"));
        System.out.println(stringUnaryOperator.apply("abcdefghijklmnopqrstuvwxyz"));
    }
}
