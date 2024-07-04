package dynamic.programming;

import java.util.Arrays;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
    }

    public static int maxProduct(int [] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        long currentMax = 1;
        long currentMin = 1;

        long result = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val == 0) {
                currentMax = 1;
                currentMin = 1;
                continue;
            }

            long tmp = currentMax;

            currentMax = Math.max(Math.max(currentMax*val, currentMin*val), val);
            currentMin = Math.min(Math.min(tmp*val, currentMin*val), val);

            result = Math.max(result, currentMax);
        }

        return (int)result;
    }
}
