package com.techrevolution.functionalinterface.ch10.shortproblem.first;

import java.util.Arrays;
import java.util.Comparator;

public class IntegerComparator {
    public static void main(String[] args) {

        Integer[] array = {9, 1, 5, 8, 5, 6, 7, 2};
        Comparator<Integer> comparator = (Comparator.comparingInt(o -> o % 2));
        Arrays.sort(array, comparator);
        System.out.println(Arrays.toString(array));
    }
}
