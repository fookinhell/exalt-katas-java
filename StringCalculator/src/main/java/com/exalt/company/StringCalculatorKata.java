package com.exalt.company;

import java.util.ArrayList;

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

        ArrayList<Integer> negativeValues = new ArrayList<>(); // init array for negatives

        String[] lineArray = numbers.split(NEW_LINE_DELIMITER); // get all the lines in the arg
        String delimiter = COMMA_DELIMITER; // default delimiter is the comma
        for (String line : lineArray) {
            if (line.startsWith(CUSTOM_DELIMITER_MARKER)) {
                delimiter = line.replace(CUSTOM_DELIMITER_MARKER, ""); // get the new delimiter
                continue; // jump to next line
            }
            String[] numberArray = line.split(delimiter);
            for (String number : numberArray) {
                try {
                    int parsedNumber = Integer.parseInt(number);
                    if (parsedNumber < 0) { // if parsed number is a negative...
                        negativeValues.add(parsedNumber); // ... add it to array
                    } else {
                        result += parsedNumber; // else add it to the result
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Something else than a number was entered : " + number);
                }
            }
        }

        if (!negativeValues.isEmpty()) {
            throw new IllegalArgumentException("Negative values are not allowed. Values entered :" + negativeValues);
        }

        return result;
    }
}
