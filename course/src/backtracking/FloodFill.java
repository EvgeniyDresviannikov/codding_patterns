package backtracking;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] result = floodFill(new int[][]{
                {1,1,0,0,1},
                {0,1,0,1,1},
                {1,1,1,0,1},
                {1,0,1,1,1},
                {1,1,0,1,1}
        }, 2, 1, 2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {

        if (grid[sr][sc] == target) return grid;

        backtrack(sr, sc, grid[sr][sc], target, grid);

        return grid;
    }

    private static void backtrack(int row, int col, int originValue, int target, int[][] result) {
        if (row > result.length-1 || row < 0 || col > result[row].length-1  || col < 0 || result[row][col] != originValue) {
            return;
        }

        result[row][col] = target;

        backtrack(row, col-1, originValue, target, result);
        backtrack(row, col+1, originValue, target, result);
        backtrack(row-1, col, originValue, target, result);
        backtrack(row+1, col, originValue, target, result);


    }
}
