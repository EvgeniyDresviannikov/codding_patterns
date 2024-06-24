package modified.binary.search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-5, 10, 19, 35, 210}, 10));
    }

    public static int binarySearch (int []nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int middle = left + (right - left)/2;
            int val = nums[middle];
            if (val == target) return middle;

            if (val > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }

        return -1;
    }
}
