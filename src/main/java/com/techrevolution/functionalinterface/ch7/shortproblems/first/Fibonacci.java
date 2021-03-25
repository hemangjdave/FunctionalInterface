package com.techrevolution.functionalinterface.ch7.shortproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

@Slf4j
public class Fibonacci {

    public static void main(String[] args) {
        new Fibonacci().generateFibonaccie(7);
        log.info("Fibonnaci series is :- {}", Arrays.deepToString(new Fibonacci().getFibonacciSeries(13)));
    }
    private Integer[] getFibonacciSeries(int number) {
        Supplier<Integer[]> supplier = () -> generateFibonaccie(number);
        return supplier.get();
    }
    private Integer[] generateFibonaccie(Integer number) {
        var firstNum = 0;
        var sumOfPreviousTwo = 0;
        var index = 0;
        var totalNumber = new Integer[number];
        IntPredicate intPredicate = value -> value == 0 || value == 1;
        while (firstNum < number) {
            if (intPredicate.test(firstNum)) {
                totalNumber[firstNum] = firstNum;
                index = firstNum;
                firstNum++;
            } else {
                sumOfPreviousTwo = totalNumber[index] + totalNumber[index - 1];
                totalNumber[firstNum] = sumOfPreviousTwo;
                index = firstNum;
                firstNum++;
            }
        }
        return totalNumber;
    }
}
