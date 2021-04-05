package com.techrevolution.functionalinterface.ch10.shortproblem.third;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class A implements Comparable<A>{

    private final String s1;
    private final String s2;
    private final int i;

    @Override
    public String toString() {
        return "A{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", i=" + i +
                '}';
    }

    @Override
    public int compareTo(A o) {
        return s1.compareTo(o.s1);
    }
}
