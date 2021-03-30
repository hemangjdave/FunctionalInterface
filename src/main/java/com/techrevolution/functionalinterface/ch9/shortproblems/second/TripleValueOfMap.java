package com.techrevolution.functionalinterface.ch9.shortproblems.second;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
public class TripleValueOfMap {
    public static void main(String[] args) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        Stream<Integer> integerStream = Stream.iterate(1, integer -> integer + 1)
                .limit(5);
        integerStream
                .forEach(integer -> integerMap.put(integer, integer));
        log.info("Hashmap with integer values:--{}", integerMap);

        log.info("Hashmap after tripling the value of the odd keys");
        Stream.iterate(1, integer -> integer + 1)
                .limit(5).filter(integer -> integer %2 != 0)
                .forEach(integer -> integerMap.computeIfPresent(integer , (k , v) -> v * 3));

        integerMap.forEach((k , v) -> log.info(k + " , " + v));
    }
}
