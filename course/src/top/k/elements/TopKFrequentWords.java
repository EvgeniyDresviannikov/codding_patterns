package top.k.elements;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o2.getValue() - o1.getValue() != 0) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i < words.length; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0)+1);
        }

        freq.entrySet().forEach(maxHeap::offer);

        List<String> result = new ArrayList<>();
        while (result.size() < k) {
            result.add(maxHeap.poll().getKey());

        }

        return result;
    }
}
