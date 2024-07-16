package hash.maps;

import java.util.HashMap;

public class LongestPalindrom {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int res = freq.values().stream().filter(val -> val > 1).map(val -> val % 2 == 0 ? val : val - 1).mapToInt(Integer::intValue).sum();

        return res < s.length() ? res+1 : res;
    }
}
