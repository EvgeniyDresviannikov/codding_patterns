package merge.intervals;

import java.util.*;

public class MeetingRooms2 {

    public static void main(String[] args) {
        System.out.println(findSets(new int[][]{ {11,12}, {3,4}, {9,10}, {5,6}, {7,8} }));
    }

    public static int findSets(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        rooms.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            Integer earliestEndTime = rooms.peek();
            if (start >= earliestEndTime) {
                rooms.poll();
                rooms.add(end);
            } else {
                rooms.add(end);
            }
        }

        return rooms.size();
    }
}
