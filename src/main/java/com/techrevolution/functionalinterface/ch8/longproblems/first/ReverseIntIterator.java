package com.techrevolution.functionalinterface.ch8.longproblems.first;

import lombok.extern.slf4j.Slf4j;

import java.util.PrimitiveIterator;
import java.util.function.IntConsumer;

@Slf4j
public class ReverseIntIterator implements Iterable<Integer> {

    private final int[] array;

    public ReverseIntIterator(int... array) {
        this.array = array;
    }

    public static void main(String[] args) {
        IntConsumer intConsumer = value -> log.info(String.valueOf(value));
        new ReverseIntIterator(1, 2, 3, 4, 5).iterator().forEachRemaining(intConsumer);
    }

    private class MyInteger implements PrimitiveIterator.OfInt {
        private int cursor;
        public MyInteger() {
            cursor = array.length - 1;
        }
        @Override
        public void forEachRemaining(IntConsumer action) {
            while (hasNext()) {
                action.accept(nextInt());
            }
        }

        @Override
        public boolean hasNext() {
            return cursor > -1;
        }

        @Override
        public int nextInt() {
            int i = 0;
            if (hasNext()) {
                i = array[cursor];
                cursor--;
            }
            return i;
        }
    }

    @Override
    public PrimitiveIterator.OfInt iterator() {
        return new MyInteger();
    }
}
