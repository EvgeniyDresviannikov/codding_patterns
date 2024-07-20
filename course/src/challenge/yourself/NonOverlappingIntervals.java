package challenge.yourself;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        System.out.println(removeMinIntervals(new int[][]{
                {1, 2}, {2, 4}, {3, 6}, {5, 10}
        }));
    }

    public static int removeMinIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int cnt = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= prevEnd) {
                prevEnd = interval[1];
            } else {
                cnt++;
                prevEnd = Math.min(prevEnd, interval[1]);
            }
        }

        return cnt;

    }
}
