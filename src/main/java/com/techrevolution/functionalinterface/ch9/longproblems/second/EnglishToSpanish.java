package com.techrevolution.functionalinterface.ch9.longproblems.second;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class EnglishToSpanish {

    public static final String AUTOMOBILE = "automobile";
    public static final String BOAT = "boat";
    public static final String AIRPLANE = "airplane";

    public static void main(String[] args) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put(AUTOMOBILE, "ground-powered vehicle with wheels");
        stringMap.put(BOAT, "vehicle that travels on water");
        stringMap.put(AIRPLANE, "powered vehicle that flies");
        Map<String, String> map = new HashMap<>();
        map.put(AUTOMOBILE, "vehiculo tierra-accionado con las ruedas");
        map.put(BOAT, "vehiculo que viaja en el agua");
        map.put(AIRPLANE, "vehiculo motorizado que vuela");
        stringMap.forEach((key, value) -> performCompute(key, map , stringMap));
        log.info("---------AFTER PERFORMING MERGE OPERATION------------");
        stringMap.forEach((key, value) -> log.info(key + " :-- " + value));
    }

    private static void performCompute(String key, Map<String, String> targetMap , Map<String , String> sourceMap) {
        sourceMap.compute(key, (k, v) -> targetMap.get(k));
    }
}
