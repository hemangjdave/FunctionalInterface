package com.techrevolution.functionalinterface.ch9.shortproblems.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class ComputeMap {

    public static final String HEMANG = "Hemang";
    public static final String KRUTARTH = "Krutarth";
    public static final String MAHARSHI = "Maharshi";

    public static void main(String[] args) {
        ComputeMap computeMap = new ComputeMap();
        log.info("-----------COMPUTE MAP----------------------");
        Map<String, Integer> map = computeMap.generateMap();
        computeMap.computeMapMethod(map);
        log.info("-----------COMPUTE MAP IFABSENT--------------");
        map = computeMap.generateMap();
        computeMap.computeMapIfAbsentMap(map);
        log.info("------------COMPUTE MAP IFPRESENT-------------");
        map = computeMap.generateMap();
        computeMap.computeMapIfPresent(map);
    }

    private void computeMapIfPresent(Map<String, Integer> map) {
        BiFunction<String, Integer, Integer> biFunction = ((s, integer) -> integer > 25 ? null : integer+5);
        map.computeIfPresent(HEMANG, biFunction);
        map.computeIfPresent(KRUTARTH, biFunction);
        map.computeIfPresent(MAHARSHI, biFunction);
        map.forEach((key, value) -> log.info(key + " is " + value));
    }

    private void computeMapIfAbsentMap(Map<String, Integer> map) {
        Function<String, Integer> function = String::length;
        Function<String, Integer> nullFunction = s -> null;
        map.computeIfAbsent("Pakiya", nullFunction);
        map.computeIfAbsent(HEMANG, function);
        map.computeIfAbsent("Shiva", function);
        map.forEach((key, value) -> log.info(key + " is " + value));
    }

    private Map<String, Integer> generateMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put(HEMANG, 29);
        map.put(KRUTARTH, 24);
        map.put(MAHARSHI, null);
        return map;
    }

    private void computeMapMethod(Map<String, Integer> map) {
        BiFunction<String, Integer, Integer> bin
                = ((str, age) -> age == null ? null : age / 4);
        log.info("age of Hemang :-- " + map.compute(HEMANG, bin));
        log.info("age of Krutarth :-- " + map.compute(KRUTARTH, bin));
        log.info("age of Maharshi :-- " + map.compute(MAHARSHI, bin));
        log.info("age of Pakiyo :-- " + map.compute("Pakiyo", bin));
        map.forEach((key, value) -> log.info(key + " is " + value));
    }
}
