package dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numOfDecodings("111111111111111111111111111111111111111111111")); // 1 - 26
    }

    public static int numOfDecodings(String s) {
        if (s.startsWith("0")) return 0;

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);

        return backtrack(0, s, dp);
    }


    private static int backtrack(int index, String decodeStr, Map<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        char first = decodeStr.charAt(index);
        if (first == '0') return 0;

        int res = backtrack(index+1, decodeStr, dp);


        if (index+1 < decodeStr.length()) {
            char second = decodeStr.charAt(index+1);
            int secondNum = Integer.valueOf(""+ first + second);
            if (secondNum <= 26) {
                res = res + backtrack(index+2, decodeStr, dp);
            }
        }

        dp.put(index, res);

        return res;
    }
}
