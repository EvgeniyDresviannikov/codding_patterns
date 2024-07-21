package challenge.yourself;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(findMajorityElement(new int[]{1,2,1,1,1}));
    }

    public static int findMajorityElement(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        int threshold = nums.length/2;

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) > threshold) return nums[i];
        }

        return -1;
    }
}
