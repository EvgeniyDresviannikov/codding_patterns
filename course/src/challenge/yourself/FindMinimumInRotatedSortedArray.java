package challenge.yourself;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMinInRotatedArray(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 1}));
    }

    public static int findMinInRotatedArray(int[] arr) {

        int left = 0;
        int right = arr.length-1;
        int res = arr[0];

        while (left <= right) {
            if (arr[left] < arr[right]) {
                res = Math.min(res, arr[left]);
                break;
            }

            int middle = left + (right - left)/2;
            res = Math.min(res, arr[middle]);

            if (arr[middle] >= arr[left]) {
                left = middle+1;
            } else {
                right = middle-1;
            }

        }
        return res;
    }
}
