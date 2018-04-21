package com.roche.andy.algorithms.DynamicProgramming;

/* Dynamic Programming Java implementation of LIS problem */
public class LongestIncreasingSubsequence {
    // Returns the length of the longest increasing subsequence in array[] of size arraySize
    private static int LIS(int array[], int arraySize) {
        int memoized[] = new int[arraySize];
        int i, j, max = 0;

        // Initialize memoized values for all indexes
        for (i = 0; i < arraySize; i++) {
            memoized[i] = 1;
        }

        // Compute optimized memoized values in bottom up manner
        for (i = 1; i < arraySize; i++) {
            for (j = 0; j < i; j++) {
                if (array[i] > array[j] && memoized[i] < memoized[j] + 1) {
                    memoized[i] = memoized[j] + 1;

                    // Update max
                    if (memoized[i] > max) {
                        max = memoized[i];
                    }
                }
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int array[] = {10, 22, 9, 33, 21, 50, 41, 60};

        System.out.println("Length of longest increasing subsequence is " + LIS(array, array.length));
    }
}
