package com.techrevolution.functionalinterface.ch11.longproblem.first;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class RevenueService {
    public static void main(String[] args) {
        Employee employee = new Employee();
        final Scanner scanner = new Scanner(System.in);
        Function<String, EmployeeType> function
                = s
                -> s.equalsIgnoreCase("w2")
                ? EmployeeType.W2
                : EmployeeType.SELF_EMPLOYEE;
        Supplier<Employee> supplier = () -> {
            log.info("Please enter employee type:--i.e W2 or SelfEmployee");
            String type = scanner.nextLine();
            employee.setType(function.apply(type));
            log.info("Please enter employee salary:--");
            employee.setIncome(scanner.nextInt());
            return employee;
        };
        log.info(supplier.get().toString());
    }
}
