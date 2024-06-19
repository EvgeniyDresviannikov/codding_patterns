package k.way.merge;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSorted(new int[]{6,7,8,9,10,0,0,0,0,0}, 5, new int[]{1,2,3,4,5}, 5)));
    }

    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {

        int p = nums1.length-1;
        int p1 = m-1;
        int p2 = n-1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }

        return nums1;
    }
}
