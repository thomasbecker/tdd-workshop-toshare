package com.example.project;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 03.05.23.
 */
class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void addMethodCalculatesSumCorrectly() {
        assertThat(calculator.add(1, 1)).isEqualTo(2);
        assertThat(calculator.add(1, 1)).isEqualTo(2);
        assertThat(calculator.add(2, 2)).isEqualTo(4);
        assertThat(calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    void substractMethodCalculatesSubstractionCorrectly() {
        assertThat(calculator.substract(4, 2)).isEqualTo(2);
        assertThat(calculator.substract(6, 2)).isEqualTo(4);
        assertThat(calculator.substract(8, 4)).isEqualTo(4);
    }

    @Test
    void multiplyMethodCalculatesFactoringCorrectly() {
        assertThat(calculator.multiply(1, 2)).isEqualTo(2);
        assertThat(calculator.multiply(2, 2)).isEqualTo(4);
        assertThat(calculator.multiply(2, 4)).isEqualTo(8);
        assertThat(calculator.multiply(4, 4)).isEqualTo(16);
    }

    @Test
    void divideMethodsCalculatesDivisEqualToionCorrectly() {
        assertThat(calculator.divide(8, 4)).isEqualTo(2);
        assertThat(calculator.divide(16, 4)).isEqualTo(4);
        assertThat(calculator.divide(32, 4)).isEqualTo(8);
        assertThat(calculator.divide(32, 2)).isEqualTo(16);
    }
}
