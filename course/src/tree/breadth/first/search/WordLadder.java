package tree.breadth.first.search;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        System.out.println(wordLadder("s", "x", List.of("x")));
    }

    public static int wordLadder(String src, String dest, List<String> words) {

        if (!words.contains(dest)) return 0;

        int counter = 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.add(src);

        Set<String> wordsRemained = new HashSet<>(words);

        while (!queue.isEmpty()) {
            String top = queue.poll();
            if (top.equals(dest)) return counter;
            counter++;

            Iterator<String> iterator = wordsRemained.iterator();
            while (iterator.hasNext()) {
                String word = iterator.next();
                if (isValid(top, word)) {
                    queue.add(word);
                    iterator.remove();
                }
            }
        }

        return 0;
    }

    private static boolean isValid(String w1, String w2) {
        int cnt = 0;

        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                cnt++;
            }
        }

        return cnt <= 1;
    }
}
