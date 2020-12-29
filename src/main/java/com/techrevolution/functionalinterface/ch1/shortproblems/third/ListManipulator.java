package com.techrevolution.functionalinterface.ch1.shortproblems.third;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface ListManipulator<T> {
    void manipulate(List<T> list , T t);

    default List<T> create(){
        return new ArrayList<>();
    }
}
