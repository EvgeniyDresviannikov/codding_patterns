package twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

class MaximizeCapital {

    public static void main(String[] args) {
        System.out.println(maximumCapital(2, 3, new int[]{1, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5}));
    }

    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {

        int currentCapital = c;

        PriorityQueue<int[]> minHeapCapitals = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        int i = 0;

        while (i < capitals.length) {
            minHeapCapitals.add(new int[]{capitals[i], i});
            i++;
        }

        i = 0;
        PriorityQueue<int[]> maxHeapProfits = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        while (i < k) {

            while (!minHeapCapitals.isEmpty() && minHeapCapitals.peek()[0] <= currentCapital) {
                int[] j = minHeapCapitals.poll();
                maxHeapProfits.add(new int[]{profits[j[1]], j[1]});
            }

            if (maxHeapProfits.isEmpty()) {
                break;
            }

            currentCapital += maxHeapProfits.poll()[0];

            i++;
        }

        return currentCapital;
    }
}
