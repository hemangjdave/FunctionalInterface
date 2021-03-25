package com.techrevolution.functionalinterface.ch7.longproblems.first;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Builder
class EBooks extends FileFormat{
    private final String title;
    private final int numOfPages;
    private final int memorySize;
}
