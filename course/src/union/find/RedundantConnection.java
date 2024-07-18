package union.find;

import java.util.Arrays;

public class RedundantConnection {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(redundantConnection(new int[][]{ {1, 2}, {1, 3}, {2, 3} })));
    }

    public static int[] redundantConnection(int[][] edges) {
        int len = edges.length;
        parent = new int[len+1];
        rank = new int[len+1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i][0], edges[i][1])) return new int[] {edges[i][0], edges[i][1]};
        }

        return new int[]{};
    }

    private static int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private static boolean union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) return false;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += p1;
        }

        return true;
    }


}
