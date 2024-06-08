package sliding.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public static String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        if (t.isEmpty()) return "";

        Map<Character, Integer> reqCounterMap = new HashMap<>();
        Map<Character, Integer> currCounterMap = new HashMap<>();

        int[] res = new int[]{-1,-1};
        int minLength = Integer.MAX_VALUE;


        for (int i = 0; i < t.length(); i++) {
            reqCounterMap.put(t.charAt(i), reqCounterMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int requiredCounter = reqCounterMap.size();
        int currCounter = 0;

        reqCounterMap.forEach((key, value) -> currCounterMap.put(key, 0));

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char currCharacter = s.charAt(end);
            if (reqCounterMap.containsKey(currCharacter)) {
                currCounterMap.put(currCharacter, currCounterMap.get(currCharacter) + 1);
                if (Objects.equals(currCounterMap.get(currCharacter), reqCounterMap.get(currCharacter))) {
                    currCounter++;
                }
            }

            while(currCounter == requiredCounter) {
                int currLength = end - start + 1;

                if (currLength < minLength) {
                    res[0] = start;
                    res[1] = end;
                    minLength = currLength;
                }

                char startCharacter = s.charAt(start);
                if (reqCounterMap.containsKey(startCharacter)) {
                    currCounterMap.put(startCharacter, currCounterMap.get(startCharacter)-1);
                    if ( currCounterMap.get(startCharacter) < reqCounterMap.get(startCharacter)) {
                        currCounter--;
                        start++;
                        break;
                    }
                }
                start++;
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);

    }

}
