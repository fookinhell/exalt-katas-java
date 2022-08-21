package com.exalt.company;

public class StringCalculatorKata {

    static final String DELIMITER = ",";

    int add(String numbers) {
        int result = 0;
        if (numbers.isEmpty()) {
            System.out.println("String is empty, returning 0");
            return result;
        }
        String[] numbersArray = numbers.split(DELIMITER);
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
