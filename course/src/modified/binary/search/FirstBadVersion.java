package modified.binary.search;

import java.util.Arrays;

public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstBadVersion(23)));
    }

    private static boolean isBad(int v) {
        return v >= 19;
    }

    public static boolean isBadVersion(int v){ // isBadVersion() is the API function that returns true or false depending upon whether the provided version ID is bad or not
        return isBad(v);
    }
//-------------------------------------------------

    public static int[] firstBadVersion(int n) {

        int counter = 0;
        int left = 1;
        int right = n;


        while (left <= right) {

            int middle = left + (right - left)/2;
            if (isBadVersion(middle)) {
                right = middle-1;
            } else {
                left = middle+1;
            }

            counter++;
        }

        return new int[]{left, counter};
    }
}
