package topological.sort;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {
        System.out.println(findOrder(3, new int[][]{ {1, 0}, {2, 0}, {2, 1}, {1, 2} }));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> inDegrees = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            inDegrees.put(i, 0);
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int child = prerequisites[i][0];
            int parent = prerequisites[i][1];

            graph.get(parent).add(child);
            inDegrees.put(child, inDegrees.get(child)+1);
        }


        PriorityQueue<Integer> queue = new PriorityQueue<>();

        inDegrees.entrySet().forEach(entry -> {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        });

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int val = queue.poll();
            result.add(val);

            graph.get(val).forEach( child -> {
                    inDegrees.put(child, inDegrees.get(child)-1);
                    if (inDegrees.get(child) == 0) {
                        queue.add(child);
                    }
            }
            );
        }

        return result.size() == graph.size() ? result.stream().mapToInt(i ->i).toArray() : new int[]{};
    }
}
