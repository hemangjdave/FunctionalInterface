package com.techrevolution.functionalinterface.ch12.practice;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
class TwoInts{
    private Integer i1;
    private Integer i2;
}

@Slf4j
public class SumOfIntsWithReduce {
    public static void main(String[] args) {
        var twoIntsStream = Stream.of(
                new TwoInts(1, 2),
                new TwoInts(8, 9)
        );

        var sum = twoIntsStream.mapToInt(TwoInts::getI2).sum();
        log.info(String.valueOf(sum));
    }
}
