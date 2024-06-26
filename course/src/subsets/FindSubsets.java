package subsets;

import java.util.ArrayList;
import java.util.List;

public class FindSubsets {

    public static void main(String[] args) {
        List<List<Integer>> res = findAllSubsets(new int[]{1,2,3});
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<List<Integer>> findAllSubsets(int[] nums) {

        List<List<Integer>> setsList = new ArrayList<>();

        int countCombinations = (int) Math.pow(2, nums.length);
        System.out.println(countCombinations);

        for (int i = 0; i < countCombinations; i++) {
            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {
                if (getBit(i, j)) {
                    int val = nums[j];
                    subset.add(val);
                }
            }
            setsList.add(subset);
        }


        return setsList;
    }

    private static boolean getBit(int num, int bit) {
        int tmp = 1 << bit;

        return (tmp & num) > 0;
    }
}
