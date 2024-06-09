package merge.intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertInterval(new int[][]{{1,2},{5,7},{8,10}}, new int[]{3,4})));
    }

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {

        List<int[]> list = new LinkedList<>();
        int[][] intervals = new int[existingIntervals.length + 1][2];
        boolean isInserted = false;
        int counter = 0;

        for (int i = 0; i < existingIntervals.length; i++) {
            if (existingIntervals[i][0] > newInterval[0] && !isInserted) {
                intervals[counter] = newInterval;
                i--;
                isInserted = true;
            } else {
                intervals[counter] = existingIntervals[i];
            }
            counter++;
        }

        if (!isInserted) {
            intervals[intervals.length-1] = newInterval;
        }

        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastItem = list.get(list.size()-1);
            if (lastItem[1] >= intervals[i][0]) {
                lastItem[1] = Math.max(lastItem[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }


        return list.toArray(new int[][]{});
    }
}
