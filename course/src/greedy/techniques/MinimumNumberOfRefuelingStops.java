package greedy.techniques;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {

    public static void main(String[] args) {
        System.out.println(minRefuelStops(14, 2, new int[][]{ {11, 30} }));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        if (startFuel >= target) return 0;

        int counter = 0;
        int fuelAccumulator = startFuel;

        PriorityQueue<Integer> fuelStationsMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stations.length; i++) {
            int[] station = stations[i];
            int distance = station[0];
            int fuel = station[1];

            while (fuelAccumulator < distance) {
                if (fuelStationsMaxHeap.isEmpty()) return -1;

                fuelAccumulator += fuelStationsMaxHeap.poll();
                counter++;
            }
            fuelStationsMaxHeap.offer(fuel);

            if (fuelAccumulator >= target) return counter;


        }

        while (fuelAccumulator < target) {
            if (fuelStationsMaxHeap.isEmpty()) return -1;
            fuelAccumulator += fuelStationsMaxHeap.poll();
            counter++;
        }

        return counter;
    }


}
