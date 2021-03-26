package com.techrevolution.functionalinterface.ch8.shortproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MapAndSetIterators {
    public static void main(String[] args) {
        Map<String, List<String>> listMap = new HashMap<>();
        listMap.put("articles", List.of("a", "an", "the"));
        listMap.put("propositions", List.of("of", "in", "on", "beside", "under", "above", "below"));
        listMap.put("verbs", List.of("is", "was", "compiled"));
        listMap.forEach((key , value) -> log.info(key + " are " + value));
    }
}
