package k.way.merge;

import java.util.*;


 class Pair {
    int i;
    int j;
    int sum;


     public Pair(int i, int j, int sum) {
         this.i = i;
         this.j = j;
         this.sum = sum;
     }
 }

public class FindKPairsWithSmallestSums {



    public static void main(String[] args) {

        List<List<Integer>> result = kSmallestPairs(new int[]{0,0,0,0,0,2,2,2,2}, new int[]{-3,22,35,56,76}, 22);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }

    }

    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int k) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.sum));
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < Math.min(k, list1.length); i++) {
            minHeap.add(new Pair(i, 0, list1[i] + list2[0]));
        }

        int counter = 0;
        while(!minHeap.isEmpty() && counter < k) {
            Pair currMin = minHeap.poll();

            int i = currMin.i;
            int j = currMin.j;

            result.add(List.of(list1[i], list2[j]));

            int nextIndex = j + 1;
            if (nextIndex < list2.length) {
                minHeap.add(new Pair( i, nextIndex, list1[i] + list2[nextIndex]));
            }
            counter++;

        }

        return result;
    }
}
