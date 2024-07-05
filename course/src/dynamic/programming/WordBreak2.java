package dynamic.programming;

import java.util.*;

public class WordBreak2 {

    static Set<String> wordDictSet = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")));
    }

    public static List<String> wordBreak(String s, List<String> WordDict) {

        wordDictSet = new HashSet<>(WordDict);

        List<String> result = new ArrayList<>();
        backtrack(s, "", result);

        return result;
    }

    private static void backtrack(String str, String currentResult, List<String> result) {
        if (str.isEmpty()) {
            result.add(currentResult.trim());
            return;
        }

        Iterator<String> iterator = wordDictSet.iterator();

        while (iterator.hasNext()) {
            String word = iterator.next();
            if (str.startsWith(word)) {
                backtrack(str.substring(word.length()), currentResult + " " + word, result);
            }
        }

    }
}
