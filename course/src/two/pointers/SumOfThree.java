package two.pointers;

import java.util.Arrays;

public class SumOfThree{

    public static void main(String[] args) {
        System.out.println(findSumOfThree(new int[]{1, 7, 3, 10, 15, 2, 6}, 21));
                                                   // 1, 2, 3, 6, 7, 10, 15
    }
    public static boolean findSumOfThree(int[] nums, int target) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int curItem = nums[i];
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int curSum = curItem + nums[left] + nums[right];
                if (curSum == target) return true;

                if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return false;
    }
}
