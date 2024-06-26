package modified.binary.search;


public class SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{5,6,1,2,3,4}, 5));
    }

    public static boolean search(int[] arr, int t) {
        // search rotation point
        int rotationIndex = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                rotationIndex = i+1;
                break;
            }
        }

        boolean res = binarySearch(arr, 0, rotationIndex-1, t);

        if (res) return true;

        res = binarySearch(arr, rotationIndex, arr.length-1, t);

        if (res) return true;


        return false;
    }


    private static boolean binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left)/2;
            int val = arr[middle];

            if (val == target) return true;

            if (val > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }

        return false;
    }
}
