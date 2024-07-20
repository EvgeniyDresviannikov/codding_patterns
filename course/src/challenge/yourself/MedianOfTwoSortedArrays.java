package challenge.yourself;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{1, 3}, new int[]{2}));   // 1, 2, 3, 4, 5
    }                                                                       // 3, 4, 5, 6

    public static double findMedian(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        int half = len / 2;

        int [] shortest = nums1.length > nums2.length ? nums2 : nums1;
        int [] largest = nums1.length > nums2.length ? nums1 : nums2;

        int l = 0;
        int r = shortest.length-1;

        while (true) {
            int i = (l+r)/2;
            int j = half - i - 2;

            int shortestLeft = i >= 0 ? shortest[i] : Integer.MIN_VALUE;
            int shortestRight = i+1 < shortest.length ? shortest[i+1] : Integer.MAX_VALUE;

            int largestLeft = j >= 0 ? largest[j] : Integer.MIN_VALUE;
            int largestRight = j+1 < largest.length ? largest[j+1] : Integer.MAX_VALUE;

            if (shortestLeft <= largestRight && largestLeft <= shortestRight) {
                //odd
                if (len%2 == 1) {
                    return Math.min(shortestRight, largestRight);
                } else {
                    return (double) (Math.max(shortestLeft, largestLeft) + Math.min(shortestRight, largestRight)) /2;
                }
            } else if (shortestLeft > largestRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

    }
}
