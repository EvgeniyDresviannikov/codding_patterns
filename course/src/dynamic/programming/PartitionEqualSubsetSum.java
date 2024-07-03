package dynamic.programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(canPartitionArray(new int[]{1,5,5, 11}));
    }

    public static boolean canPartitionArray(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = nums.length-1; i > -1; i--) {
            if (dp.contains(target)) return true;

            Set<Integer> nextDp = new HashSet<>();
            Iterator<Integer> iterator = dp.stream().iterator();
            while (iterator.hasNext()) {
                int val = iterator.next();
                nextDp.add(nums[i] + val);
                nextDp.add(val);
            }
            dp = nextDp;
        }

        return dp.contains(target);
    }


}
