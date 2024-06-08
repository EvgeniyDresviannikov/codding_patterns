package sliding.window;

public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(12, new int[]{1, 3, 4, 5, 2}));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int windowSum = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];
            if (windowSum >= target) {
                while (windowSum >= target) {
                    minWindowSize = Math.min(minWindowSize, end - start + 1);
                    if (minWindowSize == 1) return 1;
                    windowSum -= nums[start];
                    start++;
                }
            }

        }

        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}
