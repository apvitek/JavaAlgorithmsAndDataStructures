package com.roche.andy.algorithms.DynamicProgramming;

// Dynamic Programming Java implementation of LCS problem
public class LongestCommonSubsequence {
    // Returns length of LCS for sequenceA[0..lengthA - 1], sequenceB[0..lengthB - 1]
    private int lcs(char[] sequenceA, char[] sequenceB, int lengthA, int lengthB) {
        int memoized[][] = new int[lengthA + 1][lengthB + 1];

        // Following steps build memoized[lengthA + 1][lengthB + 1] in bottom up fashion.
        // Note that memoized[i][j] contains length of LCS of sequenceA[0..i - 1] and sequenceB[0..j - 1]
        for (int i = 0; i <= lengthA; i++) {
            for (int j = 0; j <= lengthB; j++) {
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

    /* Utility function to get max of 2 integers */
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is " + lcs.lcs(X, Y, m, n));
    }

}