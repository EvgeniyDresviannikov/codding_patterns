package challenge.yourself;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
            if (curSum <= 0) {
                curSum = 0;
            }
        }

        return maxSum;
    }
}
