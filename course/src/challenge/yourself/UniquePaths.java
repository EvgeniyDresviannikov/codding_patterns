package challenge.yourself;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {

        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = m-2; i > -1 ; i--) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for (int j = n-2; j > -1 ; j--) {
                newRow[j] = newRow[j+1] + row[j];
            }
            row = newRow;
        }

        return row[0];
    }
}
