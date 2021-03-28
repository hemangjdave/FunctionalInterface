package com.techrevolution.functionalinterface.ch8.shortproblems.first;

import java.util.Set;

public class SetIterator {
    public static void main(String[] args) {
        Set<String> strings = Set.of("Hemang", "Dave");
        strings.forEach(System.out::println);
    }
}
