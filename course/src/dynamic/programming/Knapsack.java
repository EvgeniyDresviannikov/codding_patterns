package dynamic.programming;

import java.util.Arrays;

class Knapsack {

    public static int findMaxKnapsackProfit(int capacity, int [] weights, int [] values) {
        // Create a table to hold intermediate values
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for(int[] row:dp) {
            Arrays.fill(row, 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                // Check if the weight of the current item is less than the current capacity
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]],
                            dp[i - 1][j]);
                }
                // We don't include the item if its weight is greater than the current capacity
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    // Driver code
    public static void main(String[] args) {

        int[][] weights = {
                { 1, 2, 3, 5 }
        };

        int[][] values = {
                { 1, 5, 4, 8 }
        };

        int[] capacity = { 6 };



        for (int i = 0; i < values.length; ++i) {
            System.out.print(i + 1);
            System.out.println(". We have a knapsack of capacity " + capacity[i] + " and we are given the following list of item values and weights:");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            System.out.println("Weights   |     Values");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            for (int j = 0; j < values[i].length; ++j)
                System.out.printf("%-10d|%6d\n", weights[i][j], values[i][j]);
            int result = findMaxKnapsackProfit(capacity[i], weights[i], values[i]);
            System.out.println("\nThe maximum we can earn is: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println();
        }
    }
}