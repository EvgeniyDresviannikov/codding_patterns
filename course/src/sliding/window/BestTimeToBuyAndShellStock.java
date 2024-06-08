package sliding.window;

public class BestTimeToBuyAndShellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {

        if (prices.length == 1) return 0;

        int maxProfit = 0;
        int buy = 0;

        for (int sell = 1; sell < prices.length; sell++) {
            if (prices[buy] < prices[sell]) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
        }

        return maxProfit;
    }
}
