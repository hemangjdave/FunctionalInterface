package com.techrevolution.functionalinterface.ch9.shortproblems.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReplacElements {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hemang");
        strings.add("Suraj");
        strings.add("Shiva");
        strings.add("Sanjay");
        strings.add("Suresh");

        strings.removeIf(s -> s.startsWith("S"));

        strings.forEach(log::info);
    }
}
