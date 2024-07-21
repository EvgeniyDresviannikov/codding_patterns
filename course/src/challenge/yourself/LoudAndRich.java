package challenge.yourself;

import java.util.*;

public class LoudAndRich {

    private static Map<Integer, List<Integer>> graph;
    private static int[] quiteArr;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(loudAndRich(
                new int[][]{ {0, 5},{1, 6},{2, 1},{3, 1},{4, 6},{5, 1},{6, 8},{7, 4},{9, 4} },
                new int[] {8, 5, 4, 1, 0, 9, 2, 3, 6, 7})));
    }

    public static int[] loudAndRich(int[][] richer, int[] quiet) {

        graph = new HashMap<>();
        quiteArr = quiet;

        int len = quiet.length;
        for (int i = 0; i < len; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < richer.length; i++) {
            int poor = richer[i][1];
            int rich = richer[i][0];
            graph.get(poor).add(rich);
        }

        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < len; i++) {
            res[i] = dfs(i, res);
        }

        return res;
    }

    private static int dfs(int index, int[] res) {
        if (res[index] != -1) return res[index];

        if (graph.get(index).isEmpty()) {
            return index;
        }


        List<Integer> richer = graph.get(index);
        int leastQuietIndex = index;
        for (int i = 0; i < richer.size(); i++) {
            int idx = dfs(richer.get(i), res);
            if (quiteArr[idx] < quiteArr[leastQuietIndex]) {
                leastQuietIndex = idx;
            }
        }
        return leastQuietIndex;
    }
}
