package modified.binary.search;

import java.util.List;

public class BinarySearchRotated {

    public static void main(String[] args) {
        System.out.println(binarySearchRotated(List.of(6, 7, 1, 2, 3, 4, 5), 5));
    }

    public static int binarySearchRotated(List<Integer> nums, int target) {

        // search rotation point
        int rotationIndex = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                rotationIndex = i+1;
                break;
            }
        }

        int res = binarySearch(nums, 0, rotationIndex-1, target);

        if (res != -1) return res;

        res = binarySearch(nums, rotationIndex, nums.size()-1, target);

        if (res != -1) return res;


        return -1;
    }

    private static int binarySearch(List<Integer> nums, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left)/2;
            int val = nums.get(middle);

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
