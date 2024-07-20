package challenge.yourself;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public static void main(String[] args) {
        System.out.println(attendAllMeetings(new int[][]{
                {1, 5}, {7, 9}, {11, 12}
        }));
    }

    public static boolean attendAllMeetings(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                return false;
            }
            prevEnd = Math.max(prevEnd, intervals[i][1]);
        }
        return true;
    }
}
