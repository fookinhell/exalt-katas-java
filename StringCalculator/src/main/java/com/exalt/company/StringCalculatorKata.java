package com.exalt.company;

public class StringCalculatorKata {

    static final String COMMA_DELIMITER = ",";
    static final String NEW_LINE_DELIMITER = "\n";
    static final String CUSTOM_DELIMITER_MARKER = "//";

    int add(String numbers) {
        int result = 0;
        if (numbers.isEmpty()) {
            System.out.println("String is empty, returning 0");
            return result;
        }

        String[] lineArray = numbers.split(NEW_LINE_DELIMITER); // get all the lines in the arg
        String delimiter = COMMA_DELIMITER; // default delimiter is the comma
        for (String line : lineArray) {
            if(line.startsWith(CUSTOM_DELIMITER_MARKER)) {
                delimiter = line.replace(CUSTOM_DELIMITER_MARKER, ""); // get the new delimiter
                continue; // jump to next line
            }
            String[] numberArray = line.split(delimiter);
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
