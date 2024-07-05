package cyclic.sort;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{1,4,5,6,8,2,0,7}));
    }

    public static int findMissingNumber(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            int val = nums[i];
            if (val == i || val > nums.length-1) {
                i++;
                continue;
            }

            int tmp = nums[val];
            nums[val] = val;
            nums[i] = tmp;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) return j;
        }

        return nums.length;
    }
}
