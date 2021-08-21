package com.roche.andy.javaLanguage;

import java.util.Hashtable;

import static com.roche.andy.sort.MergeSort.mergeSort;

public class Challenges {
    // Given an array of distinct integer values, count the number of pairs of integers that have difference K.
    private static void firstChallenge(int K, int[] list) {
        int count = 0;

        // 1. Sort list - O(n log(n))
        mergeSort(list, 0, list.length - 1);

        // 2. Insert in HashTable - O(n)
        Hashtable<Integer, Boolean> hashTable = new Hashtable<>();

        for (int number : list) {
            hashTable.put(number, Boolean.TRUE);
        }

        // 3. Loop through numbers and look up HashTable entries - O(n)
        for (int number : list) {
            if (hashTable.get(number + K) != null) {
                count++;
            }

            if (hashTable.get(number - K) != null) {
                count++;
            }
        }

        System.out.println("There are " + count + " pairs of elements with difference " + K + " in the list.");
    }

    // Given a smaller string s and a bigger string b, design an algorithm to find all permutations of the shorter
    // string within the longer one. Print the location of each permutation.
    private static void secondChallenge(String s, String b) {
        // 1. Build a has table of character frequency in s - O(n)
        Hashtable<Character, Integer> characterFrequency = new Hashtable<>();

        for (Character c : s.toCharArray()) {
            characterFrequency.merge(c, 1, (a, b1) -> a + b1);
        }

        // 2. Iterate through b and look for the frequency of the characters of s in a substring of length s
        for (int i = 0; i < b.length() - s.length(); i++) {
            String thisSubstring = b.substring(i, i + s.length());

            Hashtable<Character, Integer> characterFrequencyForSubstring = new Hashtable<>();

            for (Character c : thisSubstring.toCharArray()) {
                characterFrequencyForSubstring.merge(c, 1, (a, b1) -> a + b1);
            }

            boolean validSubstring = true;

            for (Character key : characterFrequencyForSubstring.keySet()) {
                Integer thisCount = characterFrequencyForSubstring.get(key);
                Integer otherCount = characterFrequency.get(key);

                if (!thisCount.equals(otherCount)) {
                    validSubstring = false;
                    break;
                }
            }

            if (validSubstring) {
                System.out.println("Substring present from index " + i + " to " + (i + s.length()));
            }
        }
    }

    public static void main(String[] args) {
        firstChallenge(3, new int[] { 1, 7, 5, 9, 2, 12, 3 });

        System.out.println();

        secondChallenge("abbc", "cbabadcbbabbcbabaabccbabc");
    }
}
