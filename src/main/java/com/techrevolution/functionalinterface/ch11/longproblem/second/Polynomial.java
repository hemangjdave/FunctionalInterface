package com.techrevolution.functionalinterface.ch11.longproblem.second;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Polynomial {
    public static void main(String[] args) {
        final String equation = "x^3 + 4*x^2 - 7*x - 8";
        CalculatePolynomial polynomial = new CalculatePolynomial();
        log.info(String.valueOf(polynomial.getPolynomialAnswer(equation, 5)));
    }
}
