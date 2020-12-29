package com.techrevolution.functionalinterface.ch1.longproblems.second;

@FunctionalInterface
public interface Area {
    double compute();
    default int numberOfSides(){
        return 4;
    }
}
