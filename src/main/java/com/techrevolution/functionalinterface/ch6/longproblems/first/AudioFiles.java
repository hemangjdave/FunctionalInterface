package com.techrevolution.functionalinterface.ch6.longproblems.first;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
class AudioFiles {
    private final String title;
    private final String format;
    private final int memorySize;
}
