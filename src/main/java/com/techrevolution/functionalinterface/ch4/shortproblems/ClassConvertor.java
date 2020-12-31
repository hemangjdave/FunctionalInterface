package com.techrevolution.functionalinterface.ch4.shortproblems;

import java.util.function.Function;

public class ClassConvertor {

    public static void main(String[] args) {
        Function<A, B> aTob = a -> new B(a.getaDouble(), a.getString(), a.getInteger().toString());
        Function<B, A> bToa = b -> new A(b.getaDouble(), b.getString1(), Integer.parseInt(b.getString2()));
        A a = new A(3.144444, "Hemang", 27);
        B b = new B(1.217489, "Shiva", "28");

        A convertedAFromB = bToa.apply(b);
        B convertedBFromA = aTob.apply(a);

        System.out.println(convertedAFromB);
        System.out.println(convertedBFromA);
    }
}
