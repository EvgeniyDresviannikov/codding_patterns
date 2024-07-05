package dynamic.programming;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

    public static int climbStairs(int n) {

        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[n-1] = 1;
        dp[n-2] = 2;

        for (int i = n-3; i > -1; i--) {
            dp[i] = dp[i+2]+dp[i+1];
        }
        return dp[0];
    }
}
