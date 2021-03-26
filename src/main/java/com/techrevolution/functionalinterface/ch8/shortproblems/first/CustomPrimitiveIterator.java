package com.techrevolution.functionalinterface.ch8.shortproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.function.IntConsumer;

@Slf4j
public class CustomPrimitiveIterator implements Iterable<Integer> {

    private final int[] array;

    public CustomPrimitiveIterator(int... a) {
        this.array = Arrays.copyOf(a, a.length);
    }

    public static void main(String[] args) {
        CustomPrimitiveIterator iterator = new CustomPrimitiveIterator(1, 2, 3, 4, 5);
        iterator.forEach(integer -> log.info(String.valueOf(integer)));
        System.out.println();
        IntConsumer intConsumer = integer -> log.info(String.valueOf(integer));
        iterator.iterator().forEachRemaining(intConsumer);
    }

    private class IntIterator implements PrimitiveIterator<Integer, IntConsumer> {

        private int cursor;

        public IntIterator() {
            this.cursor = 0;
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

        @Override
        public void forEachRemaining(IntConsumer action) {
            while (hasNext()) {
                action.accept(array[cursor]);
                cursor++;
            }
        }
    }


    @Override
    public PrimitiveIterator<Integer , IntConsumer> iterator() {
        return new IntIterator();
    }
}
