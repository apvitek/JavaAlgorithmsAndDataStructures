package com.roche.andy.javaLanguage;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person - name: " + name + ", age: " + age;
    }
}

class Adult extends Person {
    public Adult(String name, int age) {
        super(name, age);
    }

    public String toString() {
        return "Adult - name: " + getName() + ", age: " + getAge();
    }
}

public class MapAndFilter {
    public static void printList(List list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
    }

    public static void main(String args[]) {
        List<Person> persons = Arrays.asList(
                new Person("Paul", 15),
                new Person("Angie", 30),
                new Person("Jack", 20),
                new Person("Lawrence", 40),
                new Person("Rachel", 11)
        );

        List<String> names = persons.stream().map(Person::getName).collect(toList());
        System.out.print("Persons names: ");
        printList(names);
        System.out.println();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.print("Numbers: ");
        printList(numbers);
        System.out.println();

        // Map
        List<Integer> squares = numbers.stream().map(number -> number * number).collect(toList());
        System.out.print("Squares: ");
        printList(squares);
        System.out.println();

        // Filter
        List<Integer> even = squares.stream().filter(number -> number % 2 == 0).collect(toList());
        System.out.print("Even numbers: ");
        printList(even);
        System.out.println();

        // Map and Filter
        List<Adult> adults = persons.stream()
                .filter(person -> person.getAge() > 18)
                .map(person -> new Adult(person.getName(), person.getAge()))
                .collect(toList());

        System.out.print("Adults: ");
        printList(adults);
        System.out.println();
    }
}
