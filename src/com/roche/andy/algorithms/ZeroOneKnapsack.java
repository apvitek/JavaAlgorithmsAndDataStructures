package com.roche.andy.algorithms;

import static java.lang.Math.max;

// Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack

public class ZeroOneKnapsack {
    // Returns the maximum value that can be put in a knapsack of capacity capacity
    private static int knapsack(int capacity, int weights[], int values[], int arrayLength) {
        int memoized[][] = new int[arrayLength + 1][capacity + 1];

        // Build table memoized[][] in bottom up manner
        for (int i = 0; i <= arrayLength; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    memoized[i][j] = 0;

                } else {
                    if (weights[i - 1] <= j) {
                        memoized[i][j] = max(values[i - 1] + memoized[i - 1][j - weights[i - 1]], memoized[i - 1][j]);

                    } else {
                        memoized[i][j] = memoized[i - 1][j];
                    }
                }
            }
        }

        return memoized[arrayLength][capacity];
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void main(String args[]) {
        int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int capacity = 50;

        System.out.println(knapsack(capacity, weights, values, values.length));
    }
}