package dynamic.programming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{394,137}, 900));
    }

    public static int coinChange(int [] coins, int amount) {

        if (amount == 0) return 0;

        int[] dp = new int[amount+1];

        Arrays.sort(coins);

        if (coins[0] > amount) return -1;

        for (int currentTotal = 0; currentTotal < amount+1; currentTotal++) {
            if (currentTotal == 0) continue;

            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (coin > currentTotal) break;

                int rest = currentTotal;
                int counter = 0;
                while (rest > 0) {
                    rest -= coin;
                    counter++;
                    if (rest >= 0 && dp[rest] > 0) {
                        counter += dp[rest];
                        rest = 0;
                        break;
                    }

                }
                if (rest == 0) {
                    dp[currentTotal] = dp[currentTotal] == 0 ? counter : Math.min(dp[currentTotal], counter);
                }
            }
        }


        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
