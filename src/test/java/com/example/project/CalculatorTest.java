package com.example.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 25.07.23.
 */
class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest(name = "Given {0} + {1} then results is {2}")
    @CsvSource({
            "2, 2, 4",
            "4, 4, 8",
            "0, 4, 4",
            "-4, 4, 0",
            "2, 4, 6"
    })
    @DisplayName("Custom test name containing spaces")
    void addOperationReturnsCorrectResult(int a, int b, int expectedResult) {
        assertThat(calculator.add(a, b)).isEqualTo(expectedResult);
    }
}
