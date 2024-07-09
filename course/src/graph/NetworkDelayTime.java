package graph;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{
                {1,2,5},
                {1,3,5},
                {1,4,5},
                {2,4,5},
                {3,4,5}
        }, 4, 1));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Set<Integer> visit = new HashSet<>();
        Map<Integer, List<int[]>> edges = new HashMap<>();
        int t = 0;

        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int parent = times[i][0];
            int child = times[i][1];
            int time = times[i][2];

            edges.get(parent).add(new int[]{child, time});
        }

        minHeap.add(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();

            if (visit.contains(node[0])) continue;

            visit.add(node[0]);
            t = Math.max(t, node[1]);
            if (visit.size() == n) {
                return node[1];
            }
            edges.get(node[0]).forEach(item -> {
                if (!visit.contains(item[0])) {
                    int timeToNode = node[1] + item[1];
                    minHeap.add(new int[]{item[0], timeToNode});
                }

            });
        }

        return visit.size() == n ? t : -1;

    }
}
