package com.exalt.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    public void testWithInvalidCharacter() {
        String numbers = "13,146,2,27,18,16,54r";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(numbers));
        assertTrue(exception.getMessage().contains("Something else than a number was entered"));
    }

    @ParameterizedTest(name = "\"{0}\" should return {1}")
    @CsvSource({
            "'', 0",
            "'18', 18",
            "'18,7', 25",
            "'54,45\n65', 164",
            "'13,146,2,27,18\n16,54', 276",
            "'12\n10,24\n4', 50",
            "'//;\n3;9', 12",
            "'//\\+\n30+18', 48" // '+' is a reserved RegEx character so need to scape
    })
    public void step4_test(String numbers, int expectedResult) {
        assertEquals(expectedResult, calculator.add(numbers));
    }
}