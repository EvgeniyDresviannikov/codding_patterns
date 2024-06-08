package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(longestRepeatingCharacterReplacement("aabccbb", 2));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {
        Map<Character, Integer> counter = new HashMap<>();
        int longestLength = 0;
        int start = 0;
        int mostFreqChar = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            counter.put(currentChar, counter.getOrDefault(currentChar, 0) + 1);
            mostFreqChar = Math.max(mostFreqChar, counter.get(currentChar));

            if (end - start + 1 - mostFreqChar > k) {
                counter.put(s.charAt(start), counter.get(s.charAt(start)) -1);
                start++;
            }

            longestLength = Math.max(longestLength, end - start + 1);

        }

        return longestLength;

    }
}
