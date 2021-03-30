package com.techrevolution.functionalinterface.ch9.longproblems.third;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Book {
    private final String bookName;
    private final float price;
    private final int copyAvailable;

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", price=" + price +
                ", priceAvailable=" + copyAvailable +
                '}';
    }
}
