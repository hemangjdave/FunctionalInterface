package com.techrevolution.functionalinterface.ch11.longproblem.second;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Slf4j
public class CalculatePolynomial {

    private String replaceStringWithSubstitue(String equation, int substitute) {
        UnaryOperator<String> operator = s -> s.replace("x", String.valueOf(substitute));
        return operator.apply(equation);
    }

    private static class QueueOperations {
        final Deque<String> deque = new ArrayDeque<>();
        final Predicate<String> plusSignPredicate = s -> s.equalsIgnoreCase("+");
        final Predicate<String> signPredicate = plusSignPredicate.or(s -> s.equalsIgnoreCase("-"));

        public double getFinalAnswer(String str) {
            if (signPredicate.test(str)) {
                return pushToQueue(str);
            } else {
                return calculateValue(str);
            }
        }

        private double calculateValue(String str) {
            double answer = checkAndGetIndividualAnswer(str);
            if (deque.isEmpty()) {
                return answer;
            }
            String sign = deque.pollFirst();
            return plusSignPredicate.test(sign) ? answer : -answer;
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
            double value1 = Double.parseDouble(values[0]);
            double value2 = Double.parseDouble(values[1]);
            return Math.pow(value1, value2) * multipliedBy;
        }

        private double getMultiplicationAnswer(String regex) {
            if (regex.contains("*")) {
                ToDoubleBiFunction<Double, Integer> function = (aDouble, aDouble2) -> aDouble * aDouble2;
                int multipliedBy = getMultipliedBy(regex);
                String[] value = regex.split("[*]");
                return function.applyAsDouble(Double.parseDouble(value[1]), multipliedBy);
            }
            return Double.parseDouble(regex);
        }

        private int getMultipliedBy(String regex) {
            if (regex.contains("*")) {
                String[] values = regex.split("[*]");
                return Integer.parseInt(values[0]);
            } else {
                return 1;
            }
        }

        private double pushToQueue(String str) {
            deque.push(str);
            return 0;
        }

    }

    public double getPolynomialAnswer(String equation, int substitute) {
        equation = replaceStringWithSubstitue(equation, substitute);
        QueueOperations operations = new QueueOperations();
        return Stream.of(equation.split(" "))
                .mapToDouble(operations::getFinalAnswer)
                .sum();
    }
}
