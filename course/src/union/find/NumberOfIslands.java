package union.find;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// not finished solution
public class NumberOfIslands {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        System.out.println(numIslands(List.of(
                List.of('1', '1', '1', '1', '0'),
                List.of('1', '0', '0', '0', '1'),
                List.of('1', '1', '1', '1', '1'),
                List.of('0', '1', '0', '1', '0'),
                List.of('1', '1', '0', '1', '1')
        )));
    }

    public static int numIslands(List<List<Character>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();

        parent = new int[n*m];
        rank = new int[n*m];

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                int idx = getIndex(i, j, n, m);
                if (grid.get(i).get(j) == '0') {
                    parent[idx] = -1;
                    rank[idx] = -1;
                } else {
                    parent[idx] = idx;
                    rank[idx] = 1;
                }
            }
        }

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if (grid.get(i).get(j) == '1') {
                    int currentIndex = getIndex(i, j, n, m);
                    if (i+1 < n && grid.get(i+1).get(j) == '1') {
                        int under = getIndex(i+1, j, n, m);
                        union(currentIndex, under);
                    }
                    if (j+1 < m && grid.get(i).get(j+1) == '1') {
                        int right = getIndex(i, j+1, n, m);
                        union(currentIndex, right);
                    }


                }
            }
        }

        HashSet<Integer> tmp = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                tmp.add(parent[i]);
            }
        }

        System.out.println(Arrays.toString(parent));
        return tmp.size();
    }

    private static int getIndex(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i > n-1 || j > m-1) return -1;
        return m*i+j;
    }

    private static int find(int v) {
        if (v == -1 ) return -1;
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private static void union(int v1, int v2) {

        if (v1 == 13 && v2 == 14) {
            System.out.println("test");
        }

        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) return;

        if (rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += p1;
        }
    }
}
