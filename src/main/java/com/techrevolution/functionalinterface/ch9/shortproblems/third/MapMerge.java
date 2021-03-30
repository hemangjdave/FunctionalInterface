package com.techrevolution.functionalinterface.ch9.shortproblems.third;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapMerge {
    public static void main(String[] args) {
        Map<String, Car> carMap = new HashMap<>();
        carMap.put("S123", new Car("Hundai", "Excel"));
        carMap.put("S456", new Car("Buick", "Skylark"));
        carMap.put("S789", new Car("Toyota", "Prius"));
        carMap.merge(
                "S123",
                new Car("Chevy", "Excel"),
                (oldcar, newcar) -> new Car(newcar.make, oldcar.model)
        );
        carMap.merge(
                "S123",
                new Car("Buick", "Vega"),
                (oldcar, newcar) -> new Car(oldcar.make, newcar.model)
        );
        carMap.remove("s789");
        carMap.forEach((key , value) -> log.info(key + " " + value));
    }
}
