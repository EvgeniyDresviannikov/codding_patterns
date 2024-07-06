package topological.sort;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {

    public static void main(String[] args) {
        System.out.println(verifyAlienDictionary(new String[]{"rftt", "wrt", "wrf", "er", "ett"}, "hlabcdgiwjkmnopqerstfuvxyz"));
    }

    public static boolean verifyAlienDictionary(String[] words, String order) {

        Map<Character, Integer> alphabet = new HashMap<>();

        int count = 0;
        for (int i = 0; i < order.length(); i++) {
            count++;
            alphabet.put(order.charAt(i), count);
        }

        for (int i = 0; i < words.length-1; i++) {
            if (!backtrack(words[i], words[i+1], alphabet)) return false;
        }

        return true;
    }

    private static boolean backtrack(String word1, String word2, Map<Character, Integer> alphabet) {
        if (word1.isEmpty()) {
            return true;
        }

        if (word2.isEmpty()) return false;

        char letter1 = word1.charAt(0);
        char letter2 = word2.charAt(0);

        if (letter1 == letter2) {
            return backtrack(word1.substring(1), word2.substring(1), alphabet);
        }

        return alphabet.get(letter1) < alphabet.get(letter2);

    }
}
