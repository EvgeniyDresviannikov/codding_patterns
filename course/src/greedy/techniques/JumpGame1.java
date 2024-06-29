package greedy.techniques;

public class JumpGame1 {

    public static void main(String[] args) {
        System.out.println(jumpGame(new int[]{3,2,1,0,4}));
    }

    public static boolean jumpGame(int[] nums) {

        int currentTarget = nums.length-1;

        for (int i = nums.length-2; i >= 0 ; i--) {
            int distance = currentTarget - i;
            if (nums[i] >= distance) {
                currentTarget = i;
            }

        }

        return currentTarget == 0;
    }
}
