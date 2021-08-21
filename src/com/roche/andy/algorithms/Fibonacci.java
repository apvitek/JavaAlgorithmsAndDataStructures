package com.roche.andy.algorithms;

public class Fibonacci {
    // ----- Recursive -----
    public static int fibonacci(int number) {
        return fibonacci(number, new int[number + 1]);
    }

    private static int fibonacci(int number, int[] memoized) {
        if (number == 0 || number == 1) {
            return number;
        }

        if (memoized[number] == 0) {
            memoized[number] = fibonacci(number - 1, memoized) + fibonacci(number - 2, memoized);
        }

        return memoized[number];
    }

    // ----- Non-recursive -----
    public static int fibonacciBetter(int number) {
        // Base cases
        if (number == 0 || number == 1) {
            return number;
        }

        // Initialize memoized array
        int[] memoized = new int[number + 1];
        memoized[0] = 0;
        memoized[1] = 1;

        // Fill memoized array in bottom-up fashion
        for (int i = 2; i < number; i++) {
            memoized[i] = memoized[i - 1] + memoized[i - 2];
        }

        // Return sum of last two entries
        return memoized[number - 1] + memoized[number - 2];
    }

    // ----- Non-recursive, better -----
    public static int fibonacciBest(int number) {
        // Base cases
        if (number == 0 || number == 1) {
            return number;
        }

        // Declare variables that represent the last two entries in memoized, as it gets filled
        int a = 0;
        int b = 1;

        // Keep track of the last two entries, without computing the whole memoized array
        for (int i = 2; i < number; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        // Return sum of last two entries
        return a + b;
    }

    public static void main(String[] args) {
        int number = 1000;

        System.out.println("Fibonacci of " + number + ": " + fibonacci(number));
        System.out.println("Fibonacci of " + number + ": " + fibonacciBetter(number));
        System.out.println("Fibonacci of " + number + ": " + fibonacciBest(number));
    }
}
