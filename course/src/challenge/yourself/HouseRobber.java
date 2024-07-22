package challenge.yourself;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(robHouses(new int[]{1,5,7,3,7,2,3}));
    }

    public static int robHouses(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = nums[nums.length-2];

        for (int i = nums.length-3; i > -1; i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }


        return dp[0];
    }
}
