package com.exalt.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorKataTest {

    @Test
    void testWithEmptyString() {
        // ARRANGE
        String numbers = "";
        StringCalculatorKata calculator = new StringCalculatorKata();

        // ACT
        int sum = calculator.add(numbers);

        // ASSERT
        assertEquals(sum, 0);
    }

    @Test
    void testWithOneNumber() {
        // ARRANGE
        String numbers = "18";
        StringCalculatorKata calculator = new StringCalculatorKata();

        // ACT
        int sum = calculator.add(numbers);

        // ASSERT
        assertEquals(sum, 18);
    }

    @Test
    void testWithTwoNumbers() {
        // ARRANGE
        String numbers = "18,7";
        StringCalculatorKata calculator = new StringCalculatorKata();

        // ACT
        int sum = calculator.add(numbers);

        // ASSERT
        assertEquals(sum, 25);
    }

    @Test
    void testWithMoreThanTwoNumbers() {
        String numbers = "18,7,20";
        StringCalculatorKata calculator = new StringCalculatorKata();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(numbers));
        assertTrue(exception.getMessage().contains("The argument must take up to two numbers"));
    }

    @Test
    void testWithInvalidCharacter() {
        String numbers = "18;9";
        StringCalculatorKata calculator = new StringCalculatorKata();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(numbers));
        assertTrue(exception.getMessage().contains("Something else than a number was entered"));
    }
}