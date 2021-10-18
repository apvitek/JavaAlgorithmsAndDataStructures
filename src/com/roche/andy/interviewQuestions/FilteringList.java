package com.roche.andy.interviewQuestions;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilteringList {

    public static void printList(List list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6"
        );

        // Filter the list so that it only contains even numbers
        List<String> evenNumbers;

        evenNumbers = numbers.stream().filter(number -> Integer.parseInt(number) % 2 == 0).collect(toList());

        printList(evenNumbers);
    }

}
