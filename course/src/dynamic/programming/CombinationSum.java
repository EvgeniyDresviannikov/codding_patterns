package dynamic.programming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> currentCombination = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {

       backtrack(0, 0, nums, target);

       return result;
    }

    private static void backtrack(int index, int total, int[] nums, int target) {

        if (total == target) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if(index > nums.length-1 || total > target) {
           return;
        }

        currentCombination.add(nums[index]);

        backtrack(index, total+nums[index], nums, target);
        currentCombination.remove(Integer.valueOf(nums[index]));

        backtrack(index+1, total, nums, target);

    }
}
