package com.techrevolution.functionalinterface.ch9.shortproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

@Slf4j
public class ArraysSetall {
    public static void main(String[] args) {
        int[] myInts = new int[7];
        IntUnaryOperator intUnaryOperator = integer -> myInts.length - integer;
        Arrays.setAll(myInts , intUnaryOperator);
        log.info("array values :---{}", Arrays.toString(myInts));
        List<Integer> integers = Arrays.stream(myInts).boxed().collect(Collectors.toList());
        log.info("Before remove if list values:--{}", integers);
        integers.removeIf(integer -> integer == 1);
        integers.forEach(integer -> log.info(String.valueOf(integer)));
    }
}
