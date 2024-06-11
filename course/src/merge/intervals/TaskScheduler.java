package merge.intervals;

import java.util.*;
import java.util.stream.Collectors;

public class TaskScheduler {

    public static void main(String[] args) {
        System.out.println(leastTime(new char[]{'A', 'A', 'B', 'B'}, 2));
    }

    public static int leastTime(char[] tasks, int n) {

        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = freq.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());

        Map.Entry<Character, Integer> characterIntegerEntry = list.get(0);
        int maxFreq = characterIntegerEntry.getValue();
        int idleTime = (maxFreq - 1)*n;

        for (int i = 1; i < list.size(); i++) {
            idleTime = idleTime - Math.min(maxFreq-1, list.get(i).getValue());
        }

        if (idleTime > 0) {
            return tasks.length + idleTime;
        } else {
            return tasks.length;
        }

    }
}

