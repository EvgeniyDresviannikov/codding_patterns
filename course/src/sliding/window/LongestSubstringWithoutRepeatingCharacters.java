package sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(findLongestSubstring("abcdbea"));
    }


    public static int findLongestSubstring(String str) {

        Map<Character, Integer> window = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int prevIndex = 0;

        for (int end = 0; end < str.length(); end++) {
            char currCharacter = str.charAt(end);
            if ((!window.containsKey(currCharacter)) || window.get(currCharacter) < start) {
                window.put(currCharacter, end);
            } else {
                maxLength = Math.max(maxLength, end - start);
                prevIndex = window.get(currCharacter);
                start = prevIndex + 1;
                window.put(currCharacter, end);
            }
        }



        return Math.max(maxLength, str.length() - start);

    }
}
