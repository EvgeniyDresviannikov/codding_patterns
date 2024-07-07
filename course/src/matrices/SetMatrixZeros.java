package matrices;

import java.util.Arrays;

public class SetMatrixZeros {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(setMatrixZeros(new int[][]{
                {1, 2},
                {3, 4},
                {5, 6},
                {0, 8},
                {9, 9}
        })));
    }

    public static int[][] setMatrixZeros(int[][] matrix) {

        boolean frow = matrix[0][0] == 0;
        boolean fcol = matrix[0][0] == 0;


        if (!frow) {
            for (int i = 0; i < matrix[0].length ; i++) {
                if (matrix[0][i] == 0) {
                    frow = true;
                    break;
                }
            }
            ;
        }

        if (!fcol) {
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    fcol = true;
                    break;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }



        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (frow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (fcol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }


}
