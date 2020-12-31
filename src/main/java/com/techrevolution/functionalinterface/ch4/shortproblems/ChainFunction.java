package com.techrevolution.functionalinterface.ch4.shortproblems;

import java.util.Objects;
import java.util.function.Function;

public class ChainFunction {
    public static void main(String[] args) {
        Function<A, B> aTob = new Function<>() {
            @Override
            public B apply(A a) {
                System.out.println("First apply method");
                return new B(a.getaDouble(), a.getString(), a.getInteger().toString());
            }

            @Override
            public <V> Function<A, V> andThen(Function<? super B, ? extends V> after) {
                System.out.println("First apply method and then method");
                Objects.requireNonNull(after);
//                Function<A, V> returnFunction = a -> after.apply(apply(a));
                return (A a) -> after.apply(apply(a));
            }
        };
        Function<B, String> bStringFunction = b -> new StringBuilder()
                .append(b.getaDouble())
                .append("%")
                .append(b.getString1())
                .append("%")
                .append(b.getString2())
                .toString();

        System.out.println(aTob.andThen(bStringFunction).apply(new A(3.14789, "Hemang", 28)));
    }
}
