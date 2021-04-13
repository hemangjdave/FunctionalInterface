package com.techrevolution.functionalinterface.ch12.practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
class Car{
    private final String manu;
    private final String model;
    private final int milage;

    @Override
    public String toString() {
        return "Car{" +
                "manu='" + manu + '\'' +
                ", model='" + model + '\'' +
                ", milage=" + milage +
                '}';
    }
}


@Slf4j
public class JoiningAndGroupingWithCollectors {
    public static void main(String[] args) {
        log.info("----------JOINING BY DEMO---------------------");
        final var manuByJoining = getCarStream().map(Car::getModel)
                .collect(Collectors.joining(","));
        log.info(manuByJoining);
        log.info("---------GROUPING BY DEMO----------------------");
        getCarStream().collect(Collectors.groupingBy(Car::getManu)).forEach((k , v) -> log.info(k + ":-- " + v));
    }

    private static Stream<Car> getCarStream() {
        return Stream.of(
                new Car("Buick", "Regal", 25),
                new Car("Hundai", "Elantra", 27),
                new Car("Buick", "Skylark", 26),
                new Car("Hundai", "Accent", 30)
        );
    }
}
