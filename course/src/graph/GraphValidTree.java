package graph;

import java.util.*;

public class GraphValidTree {

    public static void main(String[] args) {
        System.out.println(validTree(3, new int[][]{
                {0, 1},
                {0, 2}
        }));
    }

    public static boolean validTree(int n, int[][] edges) {


        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> adjacent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            adjacent.get(parent).add(child);
            adjacent.get(child).add(parent);
        }

        if (!dfs(0, -1, adjacent, visited)) return false;

        return visited.size() == n;
    }

    private static boolean dfs(int i, int prev, List<List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(i)) return false;

        visited.add(i);

        for (int j = 0; j < adj.get(i).size(); j++) {
            if (prev == adj.get(i).get(j)) {
                continue;
            } else {
                if (!dfs(adj.get(i).get(j), i, adj, visited)) return false;
            }
        }

        return true;
    }

}
