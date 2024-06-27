package subsets;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {

    Map<Character, String[]> dict = new HashMap<>();
    {
        dict.put('2', new String[]{"a", "b", "c"});
        dict.put('3', new String[]{"d", "e", "f"});
        dict.put('4', new String[]{"g", "h", "i"});
        dict.put('5', new String[]{"j", "k", "l"});
        dict.put('6', new String[]{"m", "n", "o"});
        dict.put('7', new String[]{"p", "q", "r", "s"});
        dict.put('8', new String[]{"t", "u", "v"});
        dict.put('9', new String[]{"w", "x", "y", "z"});
    }


    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("29"));
    }

    public List<String> letterCombinations(String digits){

        if (digits.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        letterCombinations(new StringBuilder(), digits, result);

        return result;
    }

    private void letterCombinations(StringBuilder currentCombination, String digits, List<String> result) {
        if (currentCombination.length() == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        String[] nextLetters = dict.get(digits.charAt(currentCombination.length()));

        for (int i = 0; i < nextLetters.length; i++) {
            String letter = nextLetters[i];
            letterCombinations(currentCombination.append(letter), digits, result);
            currentCombination.deleteCharAt(currentCombination.length()-1);
        }

    }
}
