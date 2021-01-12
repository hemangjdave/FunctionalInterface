package com.techrevolution.functionalinterface.ch6.longproblems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
class EBooks {
    private final String title;
    private final int numOfPages;
    private final int memorySize;
}
