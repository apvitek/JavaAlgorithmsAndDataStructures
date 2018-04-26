package com.roche.andy.algorithms;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = 0;

        int[] memoized = new int[cost.length];

        for (int i = cost.length - 1; i >= 0; --i) {
            memoized[i] = cost[i] + Math.min(a, b);
            b = a;
            a = memoized[i];

            System.out.println("memoized[" + i + "] = " + memoized[i]);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println();
        }

        System.out.print("Final memoized array: ");

        for (int entry : memoized) {
            System.out.print(entry + " ");
        }

        System.out.println();

        return Math.min(memoized[0], memoized[1]);
    }

    public static void main(String args[]) {
        System.out.println("Min cost is " + minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println();
        System.out.println("Min cost is " + minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}