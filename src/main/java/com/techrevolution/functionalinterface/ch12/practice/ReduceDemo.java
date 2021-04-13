package com.techrevolution.functionalinterface.ch12.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class ReduceDemo {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5)
                .reduce((left, right) -> left * right)
                .ifPresent(value -> log.info(String.valueOf(value)));
    }
}
