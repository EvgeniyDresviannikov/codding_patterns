package matrices;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                {10,1,14,11,14},
                {13,4,8,2,13},
                {10,19,1,6,8},
                {20,10,8,2,12},
                {15,6,8,8,18}
        }));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length;

        int top = 0;
        int bottom = matrix.length;

        List<Integer> result = new ArrayList<>();

        while (left < right && top < bottom) {

            // left -> right
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // top -> bottom
            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right-1]);
            }
            right--;

            if (!(left < right && top < bottom)) break;

            // right -> left
            for (int i = right-1; i > left - 1; i--) {
                result.add(matrix[bottom-1][i]);
            }
            bottom--;

            // bottom -> up
            for (int i = bottom-1; i > top - 1 ; i--) {
                result.add(matrix[i][left]) ;
            }
            left++;

        }

        return result;
    }
}
