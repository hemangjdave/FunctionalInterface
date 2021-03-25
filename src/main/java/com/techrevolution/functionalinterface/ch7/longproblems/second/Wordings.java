package com.techrevolution.functionalinterface.ch7.longproblems.second;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class Wordings {
    private String wordName;
    private List<String> wordList;
}
