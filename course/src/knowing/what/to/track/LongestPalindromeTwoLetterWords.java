package knowing.what.to.track;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestPalindromeTwoLetterWords {

    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"ab", "ab", "ab", "xy", "ab", "ba", "ba", "yx"}));
    }

    public static int longestPalindrome(String[] words) {

        HashMap<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }

        int len = 0;

        Iterator<Map.Entry<String, Integer>> iterator = freq.entrySet().iterator();
        boolean central = false;

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String word = next.getKey();
            int frequency = next.getValue();
            if (word.charAt(0) == word.charAt(1)) {
                if (frequency % 2 == 0) {
                    len += 2*frequency;
                } else {
                    len += 2*(frequency-1);
                    central = true;
                }
            } else {
                String inversed = "" + word.charAt(1) + word.charAt(0);
                if (freq.containsKey(inversed)) {
                    len = len + 4*Math.min(frequency, freq.get(inversed));
                    freq.put(inversed, 0);
                }
            }
            freq.put(word, 0);
        }

        if (central) {
            len += 2;
        }

        return len;
    }
}
