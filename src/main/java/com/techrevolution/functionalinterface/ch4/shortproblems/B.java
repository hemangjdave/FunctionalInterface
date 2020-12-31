package com.techrevolution.functionalinterface.ch4.shortproblems;

public class B {
    private final Double aDouble;
    private final String string1;
    private final String string2;

    public B(Double aDouble, String string1, String string2) {
        this.aDouble = aDouble;
        this.string1 = string1;
        this.string2 = string2;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    @Override
    public String toString() {
        return "B double is:-" + aDouble + " string1 is:-" + string1 + " string2 is:--" + string2;
    }
}
