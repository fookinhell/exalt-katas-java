package com.exalt.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorKataTest {

    private StringCalculatorKata calculator;

    @BeforeEach
    public void initCalculator() {
        calculator = new StringCalculatorKata();
    }

    @AfterEach
    public void undefCalculator() {
        calculator = null;
    }

    @Test
    public void testWithMoreThanTwoNumbers() {
        String numbers = "18,7,20";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(numbers));
        assertTrue(exception.getMessage().contains("The argument must take up to two numbers"));
    }

    @Test
    public void testWithInvalidCharacter() {
        String numbers = "18;9";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(numbers));
        assertTrue(exception.getMessage().contains("Something else than a number was entered"));
    }

    @ParameterizedTest(name = "\"{0}\" should return {1}")
    @CsvSource({
            "'', 0",
            "'18', 18",
            "'18,7', 25",
            "'54,45', 99"
    })
    public void step1_testWithTwoOrLessNumbers(String numbers, int expectedResult) {
        assertEquals(expectedResult, calculator.add(numbers));
    }
}