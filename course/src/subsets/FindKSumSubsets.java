package subsets;

import java.util.*;

public class FindKSumSubsets {

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(3);
        lst.add(5);
        lst.add(21);
        lst.add(19);
        lst.add(7);
        lst.add(2);

        List<List<Integer>> result = getKSumSubsets(lst, 8);
        System.out.println(result);
    }

    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        int countOfCombinations = (int) Math.pow(2, setOfIntegers.size());
        List<List<Integer>> allCombinations = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < countOfCombinations; i++) {
            List<Integer> combination = new ArrayList<>();
            for (int j = 0; j < setOfIntegers.size(); j++) {
                if (getBit(j, i)) {
                    combination.add(setOfIntegers.get(j));
                }
            }
            allCombinations.add(combination);
        }

        for (int i = 0; i < allCombinations.size(); i++) {
            List<Integer> comb = allCombinations.get(i);
            int sum = comb.stream().mapToInt(Integer::intValue).sum();

            if (sum == targetSum) {
                result.add(comb);
            }

        }

        return result;
    }

    private static boolean getBit(int index, int num) {
        int tmp = 1 << index;
        return (tmp & num) > 0;
    }
}
