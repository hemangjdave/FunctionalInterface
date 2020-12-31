package com.techrevolution.functionalinterface.ch4.shortproblems;

public class A {
    private final Double aDouble;
    private final String string;
    private final Integer integer;

    public A(Double aDouble, String string, Integer integer) {
        this.aDouble = aDouble;
        this.string = string;
        this.integer = integer;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public String getString() {
        return string;
    }

    public Integer getInteger() {
        return integer;
    }

    @Override
    public String toString() {
        return "A double is:-" + aDouble + " string is:-" + string + " integer is:--" + integer;
    }
}

