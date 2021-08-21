package com.roche.andy.algorithms;

// Time complexity: O(n^2)

public class LongestIncreasingSubsequence {
    // Returns the length of the longest increasing subsequence in array[] of size arraySize
    public static int LIS(int[] array, int arraySize) {
        int[] memoized = new int[arraySize];
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

    // -----------------------------------------------------------------------------------------------------------------

    // Time complexity: O(n log(n))
    private static int ceilIndex(int[] array, int max, int min, int key) {
        while (min - max > 1) {
            int m = max + (min - max) / 2;

            if (array[m] >= key) {
                min = m;
            } else {
                max = m;
            }
        }

        return min;
    }

    public static int LISBetter(int[] array, int size) {
        // Add boundary case, when array size is one
        int[] memoized = new int[size];
        int len; // Always points empty slot

        memoized[0] = array[0];
        len = 1;

        for (int i = 1; i < size; i++) {
            if (array[i] < memoized[0]) {
                // New smallest value
                memoized[0] = array[i];

            } else if (array[i] > memoized[len - 1]) {
                // array[i] wants to extend largest subsequence
                memoized[len++] = array[i];

            } else {
                // array[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in memoized
                memoized[ceilIndex(memoized, -1, len - 1, array[i])] = array[i];
            }
        }

        return len;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] array = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println("Length of longest increasing subsequence is " + LIS(array, array.length));
        System.out.println("Length of longest increasing subsequence is " + LISBetter(array, array.length));
    }
}