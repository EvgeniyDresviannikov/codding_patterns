package top.k.elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CharFreq {
    char letter;
    int freq;

    public CharFreq(char letter, int freq) {
        this.letter = letter;
        this.freq = freq;
    }
}

public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaaabbacacab"));
    }

    public static String reorganizeString(String string1) {

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < string1.length(); i++) {
            char s = string1.charAt(i);
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<CharFreq> maxHeap = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);

        freq.entrySet().forEach(entry -> {
            maxHeap.add(new CharFreq(entry.getKey(), entry.getValue()));
        });

        int counter = 0;
        char prevLetter = 0;
        CharFreq item1;
        CharFreq item2 = null;
        StringBuilder result = new StringBuilder();

        while (counter < string1.length() && !maxHeap.isEmpty()) {
            // poll item
            item1 = maxHeap.poll();

            char currLetter = item1.letter;
            int currFreq = item1.freq;

            if (currLetter == prevLetter) {
                if (maxHeap.isEmpty()) return "";

                item2 = maxHeap.poll();
                currLetter = item2.letter;
                currFreq = item2.freq;
            }

            // build string
            result.append(currLetter);
            prevLetter = currLetter;

            // push back
            if (item2 != null) {
                maxHeap.add(new CharFreq(item1.letter, item1.freq));
            }

            if (currFreq > 1) {
                maxHeap.add(new CharFreq(currLetter, currFreq-1));
            }

            item2 = null;
            counter++;
        }

        String res = result.toString();
        return res.length() == string1.length() ? res : "";
    }
}
