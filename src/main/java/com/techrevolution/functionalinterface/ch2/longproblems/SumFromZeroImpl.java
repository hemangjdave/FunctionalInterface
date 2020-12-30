package com.techrevolution.functionalinterface.ch2.longproblems;

public class SumFromZeroImpl {
    public static void main(String[] args) {

        SumFromZero sumFromZero = value -> {
            var totalSum = 0;
            while (value != 0) {
                totalSum += value;
                value--;
            }
            return totalSum;
        };

        System.out.println(sumFromZero.computeTotalFromZero(7));
        System.out.println(sumFromZero.computeTotalFromZero(10));
        System.out.println(sumFromZero.computeTotalFromZero(5));
    }
}
