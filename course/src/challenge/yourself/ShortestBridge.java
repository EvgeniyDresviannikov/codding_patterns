package challenge.yourself;

import java.util.*;

public class ShortestBridge {
    static int[][] board;
    static final int[][] DIRECTIONS = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{
                {1,0,0},
                {1,0,0},
                {0,0,1}
        }));
    }

    public static int shortestBridge(int[][] grid){
        int len = grid.length;
        board = grid;

        // find the island
        boolean finished = false;
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (finished) break;
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, visited);
                    finished = true;
                    break;
                }
            }
        }

        Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>(visited);
        return bfs(queue, visited);

    }

    private static boolean isInvalid(int i, int j, Set<Map.Entry<Integer, Integer>> visited) {
        if (i < 0 || j < 0 || i > board.length-1 || j > board.length-1 || visited.contains(Map.entry(i, j)) || board[i][j] == 0) {
            return true;
        }
        return false;
    }

    private static boolean isWater(int i, int j, Set<Map.Entry<Integer, Integer>> visited) {
        if (i >= 0 && j >= 0 && i < board.length && j < board.length && !visited.contains(Map.entry(i, j)) && board[i][j] == 0) {
            return true;
        }
        return false;
    }

    private static boolean isIsland(int i, int j, Set<Map.Entry<Integer, Integer>> visited) {
        if (i >= 0 && j >= 0 && i < board.length && j < board.length && !visited.contains(Map.entry(i, j)) && board[i][j] == 1) {
            return true;
        }
        return false;
    }

    private static void dfs(int i, int j, Set<Map.Entry<Integer, Integer>> visited) {
        if (isInvalid(i, j, visited)) return;

        visited.add(Map.entry(i, j));

        for (int k = 0; k < DIRECTIONS.length; k++) {
            int r = i + DIRECTIONS[k][0];
            int c = j + DIRECTIONS[k][1];
            dfs(r, c, visited);
        }
    }

    private static int bfs(Queue<Map.Entry<Integer, Integer>> queue, Set<Map.Entry<Integer, Integer>> visited) {
        Queue<Map.Entry<Integer, Integer>> next = new ArrayDeque<>();
        int res = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                Map.Entry<Integer, Integer> pop = queue.poll();
                for (int k = 0; k < DIRECTIONS.length; k++) {
                    int r = pop.getKey() + DIRECTIONS[k][0];
                    int c = pop.getValue() + DIRECTIONS[k][1];
                    if (isWater(r, c, visited)) {
                        next.add(Map.entry(r, c));
                        visited.add(Map.entry(r, c));
                    } else if (isIsland(r, c, visited)) {
                        return res;
                    }
                }
            }

            while (!next.isEmpty()) {
                queue.add(next.poll());
            }

            res++;


        }
        return -1;
    }

}
