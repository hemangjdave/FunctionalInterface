package com.techrevolution.functionalinterface.ch6.longproblems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
class Dvd {
    private final String title;
    private final String companyName;
    private final int memorySize;
}
