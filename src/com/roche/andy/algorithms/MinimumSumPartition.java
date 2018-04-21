package com.roche.andy.algorithms;

import java.util.stream.IntStream;

// Time Complexity = O(n*sum) where n is number of elements and sum is sum of all elements

public class MinimumSumPartition {
    // Returns the minimum value of the difference of the two sets.
    private static int findMin(int arr[], int n) {
        // Calculate sum of all elements
        int sum = IntStream.of(arr).sum();

        // Create an array to store results of subproblems
        boolean memoized[][] = new boolean[n + 1][sum + 1];

        // Initialize first column as true.
        // 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++) {
            memoized[i][0] = true;
        }

        // Initialize top row, except memoized[0][0],as false.
        // With 0 elements, no other sum except 0 is possible
        for (int i = 1; i <= sum; i++) {
            memoized[0][i] = false;
        }

        // Fill the partition table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                memoized[i][j] = memoized[i - 1][j];

                // If i'th element is included
                if (arr[i - 1] <= j) {
                    memoized[i][j] |= memoized[i - 1][j - arr[i - 1]];
                }
            }
        }

        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        // Find the largest j such that memoized[n][j] is true where j loops from sum / 2 to 0
        for (int j = sum / 2; j >= 0; j--) {
            if (memoized[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }

        return diff;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 1};
        System.out.println("The minimum difference between 2 sets is " + findMin(arr, arr.length));
    }
}