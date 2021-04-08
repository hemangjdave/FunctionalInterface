package com.techrevolution.functionalinterface.ch11.longproblem.first;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Employee {
    private int income;
    private EmployeeType type;

    @Override
    public String toString() {
        return "Employee{" +
                "income=" + income +
                ", type=" + type +
                '}';
    }
}
