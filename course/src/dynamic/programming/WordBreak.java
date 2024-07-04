package dynamic.programming;

import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of(
                "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"
        )));
    }

    public static boolean wordBreak (String s, List<String> wordDict ) {
        int[] dp = new int[s.length()+1];
        return backtrack(0, s, wordDict, dp);
    }

    private static boolean backtrack(int index, String s, List<String> wordDict, int[] dp) {
        if (index == s.length()) {
            return true;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            String dictWord = wordDict.get(i);
            if (index+dictWord.length() <= s.length() && s.substring(index, index+dictWord.length()).equals(dictWord)) {
                if (dp[index+dictWord.length()] != -1 && backtrack(index+dictWord.length(), s, wordDict, dp)) {
                    return true;
                } else {
                    dp[index+dictWord.length()] = -1;
                }
            }
        }
        return false;
    }
}
