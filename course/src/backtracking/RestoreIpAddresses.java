package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestoreIpAddresses {

    private static String str = "";

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("199219239"));
    }

    public static List<String> restoreIpAddresses(String s) {
        str = s;

        Set<String> result = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            backtrack(0, i, "", 0, result);
        }

        return new ArrayList<>(result);
    }

    private static void backtrack(int currentIndex, int shift, String currentCombination, int rank, Set<String> result) {

        if (rank == 4) {
            if (currentIndex == str.length()) {
                result.add(currentCombination.substring(0, currentCombination.length()-1));
            }
            return;
        }

        if (currentIndex + shift > str.length()-1) {
            return;
        }

        String valueStr = str.substring(currentIndex, currentIndex+shift+1);
        if (valueStr.startsWith("0") && shift > 0) {
            return;
        }

        int value = Integer.parseInt(valueStr);

        if (value > 255) return;

        currentCombination = currentCombination + valueStr + ".";

        for (int i = 0; i < 3; i++) {
            backtrack(currentIndex+shift+1, i, currentCombination, rank+1, result);
        }


    }
}
