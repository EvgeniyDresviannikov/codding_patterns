package k.way.merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestNumber {

    public static void main(String[] args) {
        List<List<Integer>> in = List.of(
                List.of(1,2,7,14,15),
                List.of(14,17,18,22,25),
                List.of(2,16,19)
        );


        System.out.println(kSmallestNumber(in, 50)); // 15
    }

    public static int kSmallestNumber(List<List<Integer>> lists, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < lists.size(); i++) {
            List lst = lists.get(i);
            if (!lst.isEmpty()) {
                minHeap.add(new int[]{lists.get(i).get(0), i, 0});
            }
        }

        if (minHeap.isEmpty()) return 0;

        int counter = 0;
        int[] top = new int[]{};

        while (counter < k && !minHeap.isEmpty()) {
            top = minHeap.poll();
            int firstIndex = top[1];
            int secondIndex = top[2];

            List<Integer> lst = lists.get(firstIndex);
            if (secondIndex < lst.size()-1) {
                int newSecondIndex = secondIndex+1;
                int newValue = lst.get(newSecondIndex);
                minHeap.add(new int[]{newValue, firstIndex, newSecondIndex});
            }

            counter++;
        }


        return top[0];
    }
}
