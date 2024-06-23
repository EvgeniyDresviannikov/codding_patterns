package top.k.elements;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 2, 3, 1, 1, 2, 4, 5, 5, 6, 5}, 1));
    }

    public static List<Integer> topKFrequent(int[] arr, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }

        freq.entrySet().forEach(entry -> {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                int value = entry.getValue();
                if (value > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        });

        return minHeap.stream().map(Map.Entry::getKey).toList();
    }

}

