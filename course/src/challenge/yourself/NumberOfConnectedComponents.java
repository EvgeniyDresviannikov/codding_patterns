package challenge.yourself;


public class NumberOfConnectedComponents {

    static int[] parent;
    static int[] rank;


    public static int countComponents(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int res = n;

        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];

            res -= union(v1, v2);
        }

       return res;
    }

    private static int union(int v1, int v2) {
        int p1 = findParent(v1);
        int p2 = findParent(v2);

        if (p1 == p2) return 0;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }

    private static int findParent(int val) {
        if (parent[val] != val) {
            parent[val] = findParent(parent[val]);
        }
        return parent[val];
    }
}
