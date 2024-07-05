package cyclic.sort;

import java.util.Arrays;

public class FindTheCorruptPair {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findCorruptPair(new int[]{3,1,2,5,2})));
    }

    public static int[] findCorruptPair(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            int val = nums[i];
            if (val == i+1 || val > nums.length || val <= 0 || nums[val-1] == val) {
                i++;
                continue;
            }

            int tmp = nums[val-1];
            nums[val-1] = val;
            nums[i] = tmp;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) return new int[]{j+1, nums[j]};
        }

        return new int[]{0,0};
    }
}
