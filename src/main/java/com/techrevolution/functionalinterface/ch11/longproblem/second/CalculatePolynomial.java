package com.techrevolution.functionalinterface.ch11.longproblem.second;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Slf4j
public class CalculatePolynomial {

    private String replaceStringWithSubstitute(String equation, int substitute) {
        UnaryOperator<String> operator = s -> s.replace("x", String.valueOf(substitute));
        return operator.apply(equation);
    }

    private static class QueueOperations {
        boolean isPreviousSignPlus = true;
        final Predicate<String> plusSignPredicate = s -> s.equalsIgnoreCase("+");
        final Predicate<String> signPredicate = plusSignPredicate.or(s -> s.equalsIgnoreCase("-"));

        private double getFinalAnswer(String str) {
            if (signPredicate.test(str)) {
                isPreviousSignPlus = plusSignPredicate.test(str);
                return 0;
            } else {
                return calculateValue(str);
            }
        }

        private double calculateValue(String str) {
            double answer = checkAndGetIndividualAnswer(str);
            return isPreviousSignPlus ? answer : -answer;
        }

        private double checkAndGetIndividualAnswer(String regex) {
            if (regex.contains("^")) {
                return getPoweredNumber(regex);
            } else {
                return getMultiplicationAnswer(regex);
            }
        }
        private double getPoweredNumber(String regex) {
            int multipliedBy = getMultipliedBy(regex);
            if (multipliedBy > 1) {
                regex = regex.replace(multipliedBy + "*", "");
            }
            String[] values = regex.split("\\^");
            double value1 = getDoubleFromString(values[0]);
            double value2 = getDoubleFromString(values[1]);
            return Math.pow(value1, value2) * multipliedBy;
        }

        private double getDoubleFromString(String string) {
            return Double.parseDouble(string);
        }

        private double getMultiplicationAnswer(String regex) {
            if (regex.contains("*")) {
                ToDoubleBiFunction<Double, Integer> function = (aDouble, integer) -> aDouble * integer;
                int multipliedBy = getMultipliedBy(regex);
                String[] value = regex.split("[*]");
                return function.applyAsDouble(getDoubleFromString(value[1]), multipliedBy);
            }
            return getDoubleFromString(regex);
        }

        private int getMultipliedBy(String regex) {
            if (regex.contains("*")) {
                String[] values = regex.split("[*]");
                return Integer.parseInt(values[0]);
            } else {
                return 1;
            }
        }
    }

    public double getPolynomialAnswer(String equation, int substitute) {
        equation = replaceStringWithSubstitute(equation, substitute);
        QueueOperations operations = new QueueOperations();
        return Stream.of(equation.split(" "))
                .mapToDouble(operations::getFinalAnswer)
                .sum();
    }
}
