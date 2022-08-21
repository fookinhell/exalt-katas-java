package com.exalt.company;

public class StringCalculatorKata {

    static final String DELIMITER = ",";

    int add(String numbers) {
        if (numbers.isEmpty()) {
            System.out.println("String is empty, returning 0");
            return 0;
        }
        String[] numbersArray = numbers.split(DELIMITER);
        if (numbersArray.length > 2) {
            throw new IllegalArgumentException("The argument must take up to two numbers, separated by commas");
        } else {
            int result = 0;
            for (String s : numbersArray) {
                try {
                    result += Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Something else than a number was entered : " + s);
                }
            }
            return result;
        }
    }
}
