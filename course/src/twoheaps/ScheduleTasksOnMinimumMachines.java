package twoheaps;

import java.util.*;

public class ScheduleTasksOnMinimumMachines {

    public static void main(String[] args) {
        List<List<Integer>> in = new ArrayList<>();

        in.add(List.of(1,7));
        in.add(List.of(1,7));
        in.add(List.of(1,7));
        in.add(List.of(1,7));


        System.out.println(tasks(in));
    }

    public static int tasks(List<List<Integer>> tasksList) {

        int maxCount = 1;
        int currCount = 1;
        PriorityQueue<Integer> endTimeMinHeap = new PriorityQueue<>();


        // sort by start
        tasksList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        endTimeMinHeap.add(tasksList.get(0).get(1));

        for (int i = 1; i < tasksList.size(); i++) {
            int endTimePrev = endTimeMinHeap.peek();

            int currStartTime = tasksList.get(i).get(0);
            int currEndTime = tasksList.get(i).get(1);

            if (currStartTime >= endTimePrev) {

                while (!endTimeMinHeap.isEmpty() && endTimeMinHeap.peek() <= currStartTime) {
                    endTimeMinHeap.poll();
                }

                endTimeMinHeap.add(currEndTime);
            } else  {
                endTimeMinHeap.add(currEndTime);
            }

            currCount = endTimeMinHeap.size();
            maxCount = Math.max(maxCount, currCount);
        }

        System.out.println(tasksList);

        return maxCount;
    }
}
