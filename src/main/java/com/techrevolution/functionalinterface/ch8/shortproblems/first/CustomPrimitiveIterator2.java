package com.techrevolution.functionalinterface.ch8.shortproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.function.IntConsumer;

@Slf4j
public class CustomPrimitiveIterator2 implements Iterable<Integer> {

    private final int[] array;

    public CustomPrimitiveIterator2(int... array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public static void main(String[] args) {
        CustomPrimitiveIterator2 iterator2 = new CustomPrimitiveIterator2(1, 2, 3, 4, 5);
        iterator2.forEach(integer -> log.info(String.valueOf(integer)));
        IntConsumer intConsumer = integer -> log.info(String.valueOf(integer));
        iterator2.iterator().forEachRemaining(intConsumer);
    }

    private class PrimitiveOfIntIterator implements PrimitiveIterator.OfInt {

        private int cursor;

        public PrimitiveOfIntIterator() {
            cursor = 0;
        }

        @Override
        public int nextInt() {
            var i = 0;
            if (hasNext()) {
                i = array[cursor];
                cursor++;
            }
            return i;
        }

        @Override
        public boolean hasNext() {
            return cursor < array.length;
        }
    }

    @Override
    public PrimitiveIterator.OfInt iterator() {
        return new PrimitiveOfIntIterator();
    }
}
