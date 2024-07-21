package challenge.yourself;

import java.util.Arrays;

public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[] {0,1,0,3,2,3} ));
    }

    public static int longestSubsequence(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = nums.length-1; i > -1; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();

    }


}
