package com.roche.andy.algorithms;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairsVerbose(int[] cost) {
        int a = 0;
        int b = 0;

        int[] memoized = new int[cost.length];

        for (int i = cost.length - 1; i >= 0; --i) {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("cost[" + i + "] = " + cost[i]);

            memoized[i] = cost[i] + Math.min(a, b);
            System.out.println();
            System.out.println("memoized[" + i + "] = " + cost[i] + " + min(" + a + ", " + b + ") = " + memoized[i]);
            System.out.println();

            b = a;
            a = memoized[i];

            System.out.println("now a = memoized = " + a);
            System.out.println("now b = a = " + b);
            System.out.println();

            printMemoizedArray(memoized);
            System.out.println("----------");
        }

        return Math.min(memoized[0], memoized[1]);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = 0;

        int[] memoized = new int[cost.length];

        for (int i = cost.length - 1; i >= 0; --i) {
            memoized[i] = cost[i] + Math.min(a, b);
            b = a;
            a = memoized[i];
        }

        return Math.min(memoized[0], memoized[1]);
    }

    public static int minCostClimbingStairsBetter(int[] cost) {
        int a = 0;
        int b = 0;

        for (int i = cost.length - 1; i >= 0; --i) {
            int c = cost[i] + Math.min(a, b);
            b = a;
            a = c;
        }

        return Math.min(a, b);
    }

    private static void printMemoizedArray(int[] memoized) {
        System.out.print("Memoized array: [ ");

        for (int entry : memoized) {
            System.out.print(entry + " ");
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        //        System.out.println("Min cost is " + minCostClimbingStairsVerbose(new int[]{10, 15, 20}));
        //        System.out.println();
        System.out.println(
                "Min cost is " + minCostClimbingStairsVerbose(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
    }
}