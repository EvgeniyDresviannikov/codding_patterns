package matrices;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateImage(new int[][]{
                {3,1,1,7},
                {15,12,13,13},
                {4,14,12,4},
                {10,5,11,12}
        })));
    }

    public static int[][] rotateImage(int[][] matrix) {

        int l = 0;
        int r = matrix.length-1;

        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int top = l;
                int bottom = r;

                int topLeft = matrix[top][l+i];

                matrix[top][l+i] = matrix[bottom-i][l];

                matrix[bottom-i][l] = matrix[bottom][r-i];

                matrix[bottom][r-i] = matrix[top+i][r];

                matrix[top+i][r] = topLeft;
            }
            l++;
            r--;
        }

        return matrix;
    }
}
