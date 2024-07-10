package graph;

import java.util.*;


public class BusRoutes {

    public static void main(String[] args) {
        System.out.println(minimumBuses(new int[][]{
                {2, 5, 7},
                {4, 6, 7}
        }, 2, 6));
    }


    public static int minimumBuses(int[][] routes, int source, int target) {
        Map <Integer, List <Integer>> adjList = new HashMap < > ();
        for (int i = 0; i < routes.length; i++) {
            for (int station: routes[i]) {
                if (!adjList.containsKey(station)) {
                    adjList.put(station, new ArrayList < > ());
                }
                adjList.get(station).add(i);
            }
        }

        Deque < int[] > queue = new ArrayDeque < > ();
        queue.add(new int[] {source, 0});

        Set < Integer > visitedBuses = new HashSet < > ();

        while (!queue.isEmpty()) {
            int[] current = queue.peek();
            int station = current[0];
            int busesTaken = current[1];
            queue.poll();


            if (station == target) {
                return busesTaken;
            }

            if (adjList.containsKey(station)) {
                for (int bus: adjList.get(station)) {
                    if (!visitedBuses.contains(bus)) {
                        for (int s: routes[bus]) {
                            queue.add(new int[] {
                                    s,
                                    busesTaken + 1
                            });
                        }
                        visitedBuses.add(bus);
                    }
                }
            }
        }

        return -1;
    }


}
