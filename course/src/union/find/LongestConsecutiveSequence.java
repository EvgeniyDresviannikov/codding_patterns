package union.find;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequence(new int[]{21, 22, 1, 2, 3, 2}));
    }

    public static int longestConsecutiveSequence(int[] nums) {

        int maxLen = 0;

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int curLen = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num-1)) {
                curLen = 0;
                while (set.contains(num)) {
                    curLen++;
                    num = num+1;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }
}
