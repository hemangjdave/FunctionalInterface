package com.techrevolution.functionalinterface.ch10.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Slf4j
public class ComparingObjects {
    public static void main(String[] args) {
        String string = removeVowels("Hemang Dave");
        log.info(string);
        Comparator<String> stringComparator = String::compareTo;

        Comparator<String> comparator = Comparator.naturalOrder();
        log.info(String.valueOf(comparator.thenComparing(stringComparator).compare("Larry", "Libby")));
        log.info(String.valueOf(comparator.reversed().thenComparing(stringComparator).compare("Larry", "Libby")));
        log.info(String.valueOf(stringComparator.thenComparing(stringComparator).compare("Larry" , "Libby")));
        log.info(String.valueOf(Comparator.nullsFirst(stringComparator).compare("Larry", "Libby")));
    }

    private static String removeVowels(String str) {
        return str.replaceAll("[aeiou]", "");
    }
}
