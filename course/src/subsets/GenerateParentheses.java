package subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateCombinations(5));
    }

    public static ArrayList<String> generateCombinations(int n) {

        if (n == 0) return new ArrayList<>();

        ArrayList<String> result = new ArrayList<String>();

        backtrack(new StringBuilder("("), n, 1, 0, result);

        return result;
    }

    private static void backtrack(StringBuilder currentCombination, int n, int openedCounter, int closedCounter, List<String> result) {

        // return condition
        if (currentCombination.length() == 2*n) {
            if (openedCounter == closedCounter) {
                result.add(currentCombination.toString());
            }
            return;
        }

        // validation
        if (openedCounter > n || (closedCounter > openedCounter)) return;

        // go deeper
        if (openedCounter <= n) {
            backtrack(currentCombination.append("("), n,openedCounter+1, closedCounter, result);
            currentCombination.deleteCharAt(currentCombination.length()-1);
        }

        if (closedCounter <= n) {
            backtrack(currentCombination.append(")"), n,openedCounter, closedCounter+1, result);
            currentCombination.deleteCharAt(currentCombination.length()-1);

        }

    }
}
