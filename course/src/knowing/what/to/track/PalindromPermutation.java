package knowing.what.to.track;

import java.util.HashMap;

public class PalindromPermutation {

    public static void main(String[] args) {
        System.out.println(permutePalindrome("aabbcaa"));
    }

    public static boolean permutePalindrome(String st) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        long cntOdd = freq.values().stream().filter(val -> val%2 > 0).count();
        return cntOdd < 2;
    }
}
