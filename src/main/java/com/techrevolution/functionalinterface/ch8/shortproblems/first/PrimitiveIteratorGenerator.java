package com.techrevolution.functionalinterface.ch8.shortproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.function.IntConsumer;

@Slf4j
public class PrimitiveIteratorGenerator implements PrimitiveIterator<Integer, IntConsumer> {
    private final int[] array;
    private int cursor;
    public PrimitiveIteratorGenerator(int... array) {
        this.array = Arrays.copyOf(array, array.length);
        cursor = 0;
    }
    public static void main(String[] args) {
        PrimitiveIteratorGenerator generator
                = new PrimitiveIteratorGenerator(1, 2, 3, 4, 5);
        IntConsumer intConsumer = num -> log.info(String.valueOf(num));
        generator.forEachRemaining(intConsumer);
    }
    @Override
    public void forEachRemaining(IntConsumer action) {
        while (hasNext()) {
            action.accept(array[cursor]);
            cursor++;
        }
    }
    @Override
    public boolean hasNext() {
        return cursor < array.length;
    }
    @Override
    public Integer next() {
        int i = 0;
        if (hasNext()) {
            i = array[cursor];
            cursor++;
        }
        return i;
    }
}