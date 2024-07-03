package dynamic.programming;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingBits(6)));
    }

    public static int[] countingBits(int n) {

        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 0; i < n+1; i++) {

            if ((i % 2) == 0) {
                result[i] = result[i / 2];
            }
            else {
                result[i] = result[i / 2] + 1;
            }
        }

        return result;
    }
}
