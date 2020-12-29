package com.techrevolution.functionalinterface.ch1.shortproblems.third;

import java.util.ArrayList;
import java.util.List;

public class ListManipulatorImpl {
    public static void main(String[] args) {

        ListManipulator<String> stringListManipulator = (List::add);

        ListManipulator<Integer> integerListManipulator = new ListManipulator<>() {
            @Override
            public void manipulate(List<Integer> list, Integer integer) {
                list.add(integer);
            }

            @Override
            public List<Integer> create() {
                return new ArrayList<>(50);
            }
        };

        ListManipulator<Integer> removeListManipulator = ListManipulatorImpl::removeElementFromList;


        List<String> strings = new ArrayList<>();
        stringListManipulator.manipulate(strings, "Hemang");
        stringListManipulator.manipulate(strings, "Shiva");
        stringListManipulator.manipulate(strings, "Krutarth");
        stringListManipulator.manipulate(strings, "Viral");
        System.out.println("StringManipulator produced this output" + strings);

        List<Integer> integerList = integerListManipulator.create();
        integerListManipulator.manipulate(integerList, 1);
        integerListManipulator.manipulate(integerList, 1);
        integerListManipulator.manipulate(integerList, 2);
        integerListManipulator.manipulate(integerList, 3);
        integerListManipulator.manipulate(integerList, 4);
        integerListManipulator.manipulate(integerList, 5);
        System.out.println("IntegerListManipulator produces this output" + integerList);
        removeListManipulator.manipulate(integerList, 1);
        System.out.println("IntegerListManipulator produces this output" + integerList);
    }

    private static <T> void removeElementFromList(List<T> list, T t) {
        var index = list.indexOf(t);
        if (index > -1) {
            list.remove(index);
        }
    }
}
