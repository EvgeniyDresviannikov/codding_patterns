package dynamic.programming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }

    public static int longestCommonSubsequence(String str1, String str2) {

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[dp.length-1][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][dp[0].length-1] = 0;
        }

        for (int i = str1.length()-1; i > -1; i--) {
            for (int j = str2.length()-1; j > -1; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }

        }


        return dp[0][0];

    }


}
