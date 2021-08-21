package com.roche.andy.algorithms;

import static java.lang.Math.max;

// Time Complexity: O(mn) which is much better than the worst case time complexity of Naive Recursive implementation,
// O(2^n)

public class LongestCommonSubsequence {
    // Returns length of LCS for sequenceA[0..lengthA - 1], sequenceB[0..lengthB - 1]
    public static int LCS(String a, String b) {
        char[] sequenceA = a.toCharArray();
        char[] sequenceB = b.toCharArray();

        int lengthA = sequenceA.length;
        int lengthB = sequenceB.length;

        int[][] memoized = new int[lengthA + 1][lengthB + 1];

        // Following steps build memoized[lengthA + 1][lengthB + 1] in bottom up fashion.
        // Note that memoized[i][j] contains length of LCS of sequenceA[0..i - 1] and sequenceB[0..j - 1]
        for (int i = 0; i <= lengthA; i++) {
            for (int j = 0; j <= lengthB; j++) {
                // Can't get a match if either sequence ran out
                if (i == 0 || j == 0) {
                    memoized[i][j] = 0;

                } else {
                    if (sequenceA[i - 1] == sequenceB[j - 1]) {
                        memoized[i][j] = memoized[i - 1][j - 1] + 1;

                    } else {
                        memoized[i][j] = max(memoized[i - 1][j], memoized[i][j - 1]);
                    }
                }
            }
        }

        return memoized[lengthA][lengthB];
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("Length of LCS in " + s1 + " and " + s2 + " is " + LCS(s1, s2));
    }

}