package com.example.project;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.assertj.core.api.BDDAssertions.then;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 25.07.23.
 */
class CalculatorTest implements WithAssertions {
    private static final Logger log = LoggerFactory.getLogger(CalculatorTest.class);

    Calculator calculator = new Calculator();

    @ParameterizedTest(name = "Given {0} + {1} then results is {2}")
    @CsvSource({"2, 2, 4", "4, 4, 8", "0, 4, 4", "-4, 4, 0", "2, 4, 6"})
    @DisplayName("Sum operations calculate the correct results")
    void addOperationReturnsCorrectResult(int a, int b, int expectedResult) {
        log.info("%d + %d and expected result is %d".formatted(a, b, expectedResult));
        assertThat(calculator.add(a, b)).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "Given {0} - {1} then results is {2}")
    @CsvSource({"2, 2, 0", "4, 4, 0", "0, 4, -4", "-4, 4, -8", "12, 4, 8"})
    @DisplayName("Subtract operations calculate the correct results")
    void subtractOperationReturnsCorrectResult(int a, int b, int expectedResult) {
        assertThat(calculator.subtract(a, b)).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "Given {0} * {1} then results is {2}")
    @CsvSource({"2, 2, 4", "4, 4, 16", "0, 4, 0", "-4, 4, -16", "2, 4, 8"})
    @DisplayName("Multiply operations calculate the correct results")
    void multiplyOperationReturnsCorrectResult(int a, int b, int expectedResult) {
        assertThat(calculator.multiply(a, b)).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "Given {0} / {1} then results is {2}")
    @CsvSource({"2, 2, 1", "4, 4, 1", "0, 4, 0", "-4, 4, -1", "2, 4, 0"})
    @DisplayName("Divide operations calculate the correct results")
    void divideOperationReturnsCorrectResult(int a, int b, int expectedResult) {
        assertThat(calculator.divide(a, b)).isEqualTo(expectedResult);
    }
}
