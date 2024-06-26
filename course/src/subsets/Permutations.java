package subsets;

import java.util.ArrayList;
import java.util.List;

class Permutations {

    public static void main(String[] args) {
        System.out.println(permuteWord("abc"));
    }

    public static ArrayList<String> permuteWord(String word) {

        ArrayList<String> result = new ArrayList<>();

        permute(word, 0, result);

        return result;
    }

    private static void permute(String word, int currentIndex, List<String> result) {
        if (currentIndex == word.length()-1) {
            result.add(word);
            return;
        }

        for (int i = currentIndex; i < word.length(); i++) {
            String swappedWord = swap(word, currentIndex, i);
            permute(swappedWord, currentIndex+1, result);
        }

    }

    private static String swap(String wordStr, int sourceIndex, int destIndex) {
        char[] word = wordStr.toCharArray();
        char tmp = word[sourceIndex];
        word[sourceIndex] = word[destIndex];
        word[destIndex] = tmp;
        return new String(word);
    }


}