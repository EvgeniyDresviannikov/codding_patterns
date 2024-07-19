package challenge.yourself;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestBridge {
    static int[] parent;
    static int[] rank;
    static int n;
    static  int m;
    static int minDistance = Integer.MAX_VALUE;
    static int[][] board;

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{
                {1,0,0},
                {1,0,0},
                {0,0,1}
        }));
    }

    public static int shortestBridge(int[][] grid){

        board = grid;

        n = grid.length;
        m = grid[0].length;

        parent = new int[n*m];
        rank = new int[n*m];

        //build parent and rank
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = getIndexInParent(i, j);
                if (board[i][j] == 1) {
                    parent[idx] = idx;
                    rank[idx] = 1;
                } else {
                    parent[idx] = -1;
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int currentIdx = getIndexInParent(i, j);
                    // right cell
                    if (j+1 < m && grid[i][j+1] == 1) {
                        union(currentIdx, currentIdx+1);
                    }
                    if (i+1 < n && grid[i+1][j] == 1) {
                        union(currentIdx, getIndexInParent(i+1, j));
                    }
                }
            }
        }

        // define two islands (setIds)
        int oneSet = 0;
        int secondSet = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] > 0) {
                if (oneSet == 0) {
                    oneSet = parent[i];
                } else if (parent[i] != oneSet) {
                    secondSet = parent[i];
                    break;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && parent[getIndexInParent(i, j)] == oneSet) {
                    if (j+1 < m && grid[i][j+1] == 0) {
                        dfs(i, j+1, new HashSet<>(), 0, secondSet);
                    }
                    if (j-1 > -1 && grid[i][j-1] == 0) {
                        dfs(i, j-1, new HashSet<>(), 0, secondSet);
                    }
                    if (i+1 < n && grid[i+1][j] == 0) {
                        dfs(i+1, j, new HashSet<>(), 0, secondSet);
                    }
                    if (i-1 > -1 && grid[i-1][j] == 0) {
                        dfs(i-1, j, new HashSet<>(), 0, secondSet);
                    }
                }
            }
        }

        return minDistance;
    }

    static void dfs(int i, int j, Set<Map.Entry<Integer, Integer>> visited, int counter, int island) {
        if (i > n-1 || j > m-1 || i < 0 || j < 0) {
            return;
        }

        if (visited.contains(Map.entry(i, j)) || (board[i][j] == 1 && parent[getIndexInParent(i, j)] != island)) {
            return;
        }

        if (board[i][j] == 1 && parent[getIndexInParent(i, j)] == island) {
            minDistance = Math.min(minDistance, counter);
            return;
        }

        visited.add(Map.entry(i, j));

        dfs(i-1, j, visited, counter+1, island);
        dfs(i+1, j, visited, counter+1, island);
        dfs(i, j-1, visited, counter+1, island);
        dfs(i, j+1, visited, counter+1, island);

        visited.remove(Map.entry(i, j));

    }

    static int getIndexInParent(int i, int j) {
        return n*i + j;
    }

    static void union(int first, int second) {
        int p1 = findSet(first);
        int p2 = findSet(second);
        if (p1 == p2) {
            return;
        }

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
    }

    static int findSet(int val) {

        if (val != parent[val]) {
            parent[val] = findSet(parent[val]);
        }
        return parent[val];
    }


}
