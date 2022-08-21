package com.exalt.company;

public class StringCalculatorKata {

    static final String COMMA_DELIMITER = ",";
    static final String NEW_LINE_DELIMITER = "\n";

    int add(String numbers) {
        int result = 0;
        if (numbers.isEmpty()) {
            System.out.println("String is empty, returning 0");
            return result;
        }
        String[] lineArray = numbers.split(NEW_LINE_DELIMITER);
        for (String line : lineArray) {
            String[] numberArray = line.split(COMMA_DELIMITER);
            for (String number : numberArray) {
                try {
                    result += Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Something else than a number was entered : " + number);
                }
            }
        }
        return result;
    }
}
