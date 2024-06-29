package greedy.techniques;

public class JumpGame2 {

    public static void main(String[] args) {
        System.out.println(jumpGame2(new int[]{1,2,3,4,5}));
    }

    public static int jumpGame2(int[] nums) {

        int left = 0;
        int right = 0;
        int result = 0;
        
        while (right < nums.length-1) {
            int farthest = 0;
            for (int i = left; i < right+1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right+1;
            right = farthest;
            result += 1;
        }

        return result;

    }
}
