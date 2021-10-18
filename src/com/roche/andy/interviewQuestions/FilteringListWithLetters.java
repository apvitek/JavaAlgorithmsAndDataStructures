package com.roche.andy.interviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class FilteringListWithLetters {

    public static void printList(List list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        return pattern.matcher(strNum).matches();
    }

    public static boolean isNumericWithException(String strNum) {
        if (strNum == null) {
            return false;
        }

        try {
            Integer.parseInt(strNum);
            return true;

        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> numbersAndLetters = Arrays.asList(
            "0", "a", "1", "2", "3", "4", "b", "5", "6"
        );

        // Filter the list so that it only contains even numbers
        List<String> evenNumbers;

        evenNumbers = numbersAndLetters.stream()
                                       .filter(number -> isNumeric(number)
                                                             && Integer.parseInt(number) % 2 == 0)
                                       .collect(toList());

        printList(evenNumbers);

        evenNumbers = numbersAndLetters.stream()
                                       .filter(number -> isNumericWithException(number)
                                                             && Integer.parseInt(number) % 2 == 0)
                                       .collect(toList());

        printList(evenNumbers);
    }

}
