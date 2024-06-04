package fast.slow.pointers;

public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 5, 2, 3, 4}));
    }

    public static int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
