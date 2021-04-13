package com.techrevolution.functionalinterface.ch12.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class StreamPractice {
    public static void main(String[] args) {
        IntStream stream = IntStream.range(0, 10);
        stream.forEach(i -> log.info(String.valueOf(i)));
    }
}
