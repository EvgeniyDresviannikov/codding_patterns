package backtracking;

public class WordSearch {

    public static void main(String[] args) {
        System.out.println(wordSearch(new char[][]{ {'C','A','A'},
                                                    {'A','A','A'},
                                                    {'B','C','D'}
        }, "AAB"));
    }

    public static boolean wordSearch(char[][] grid, String word) {

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                boolean result = backtrack(word, 0, r, c, grid);
                if (result) return true;
            }
        }

        return  false;
    }

    private static boolean backtrack(String word, int currentIndex, int row, int col, char[][] grid) {

        if (currentIndex == word.length()) {
            return true;
        }

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '#') {
            return false;
        }

        char letter = word.charAt(currentIndex);
        if (grid[row][col] == letter) {
            grid[row][col] = '#';
            currentIndex++;

            if (backtrack(word, currentIndex, row, col-1, grid)) return true;
            if (backtrack(word, currentIndex, row, col+1, grid)) return true;
            if (backtrack(word, currentIndex, row-1, col, grid)) return true;
            if (backtrack(word, currentIndex, row+1, col, grid)) return true;

            grid[row][col] = word.charAt(currentIndex-1);
        }

        return false;
    }
}
