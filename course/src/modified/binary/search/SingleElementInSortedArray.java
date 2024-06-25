package modified.binary.search;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{0,1,1,2,2,3,3,4,4,5,5,8,8}));
    }

    public static int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (mid%2 != 0) mid--;

            if (nums[mid] == nums[mid+1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }


        return nums[left];
    }
}
