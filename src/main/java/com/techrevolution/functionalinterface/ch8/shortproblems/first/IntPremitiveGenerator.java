package com.techrevolution.functionalinterface.ch8.shortproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.PrimitiveIterator;
import java.util.function.IntConsumer;

@Slf4j
public class IntPremitiveGenerator implements PrimitiveIterator.OfInt{
    private final int[] numbers;
    private int cursor;
    public IntPremitiveGenerator(int... numbers) {
        this.numbers = numbers;
        this.cursor = 0;
    }
    public static void main(String[] args) {
        IntPremitiveGenerator generator
                = new IntPremitiveGenerator(1,2,3,4,5,6);
        IntConsumer intConsumer = number -> log.info("Number is:--" + number);
        generator.forEachRemaining(intConsumer);
    }
    @Override
    public int nextInt() {
        if (hasNext()) {
            cursor++;
            return numbers[cursor];
        }
        return 0;
    }
    @Override
    public void forEachRemaining(IntConsumer action) {
        while (hasNext()) {
            action.accept(numbers[cursor]);
            cursor++;
        }
    }
    @Override
    public boolean hasNext() {
        return cursor < numbers.length;
    }
}