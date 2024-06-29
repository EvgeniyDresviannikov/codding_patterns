package backtracking;

import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static int solveNQueens(int n) {

        Set<Integer> cols = new HashSet<>();
        Set<Integer> positiveDiagonal = new HashSet<>();
        Set<Integer> negativeDiagonal = new HashSet<>();

        List<char[][]> result = new ArrayList<>();
        char[][] currentState = new char[n][n];


        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState.length; j++) {
                currentState[i][j] = '.';
            }
        }


        backtrack(0, currentState, cols, positiveDiagonal, negativeDiagonal, result);

        return result.size();

    }

    private static void backtrack(int r,
                                  char[][] currentState,
                                  Set<Integer> cols,
                                  Set<Integer> positiveDiagonal,
                                  Set<Integer> negativeDiagonal,
                                  List<char[][]> result) {

        if (r == currentState.length) {
            result.add(currentState);
            return;
        }

        for (int c = 0; c < currentState.length; c++) {
            if (cols.contains(c) || positiveDiagonal.contains(r+c) || negativeDiagonal.contains(r-c)) {
                continue;
            }

            currentState[r][c] = 'Q';
            cols.add(c);
            positiveDiagonal.add(r+c);
            negativeDiagonal.add(r-c);

            backtrack(r+1, currentState, cols, positiveDiagonal, negativeDiagonal, result);

            currentState[r][c] = '.';
            cols.remove(c);
            positiveDiagonal.remove(r+c);
            negativeDiagonal.remove(r-c);
        }
    }

}