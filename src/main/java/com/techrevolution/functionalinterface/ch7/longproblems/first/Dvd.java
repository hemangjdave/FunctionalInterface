package com.techrevolution.functionalinterface.ch7.longproblems.first;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Builder
class Dvd extends FileFormat{
    private final String title;
    private final String companyName;
    private final int memorySize;
}
