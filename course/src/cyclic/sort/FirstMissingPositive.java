package cyclic.sort;

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositiveInteger(new int[]{1,1}));
    }

    public static int firstMissingPositiveInteger(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            int val = nums[i];
            if (val == i+1 || val > nums.length || val <= 0 || nums[val-1] == val) {
                i++;
                continue;
            }

            int tmp = nums[val-1];
            nums[val-1] = val;
            nums[i] = tmp;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) return j+1;
        }

        return nums.length+1;
    }
}
