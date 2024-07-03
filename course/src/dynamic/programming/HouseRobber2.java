package dynamic.programming;

import java.util.Arrays;

public class HouseRobber2 {

    public static void main(String[] args) {
        System.out.println(houseRobber(new int[]{10, 5, 12, 20, 3, 7, 10}));
    }

    public static int houseRobber(int[] money) {

        int len = money.length;
        if (len == 0) return 0;
        if (len == 1) return money[0];
        if (len == 2) return Math.max(money[0], money[1]);

        return Math.max(getMaxSum(Arrays.copyOfRange(money, 0, money.length-1)),
                getMaxSum(Arrays.copyOfRange(money, 1, money.length)));
    }

    private static int getMaxSum(int[] money) {
        int[] dp = new int[money.length];

        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(money[i]+dp[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
