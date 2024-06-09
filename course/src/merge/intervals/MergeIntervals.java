package merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class MergeIntervals {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeIntervals(new int[][]{ {2, 4}, {3, 5}, {4, 5}, {6, 10}, {12, 14} })));
    }

    public static int[][] mergeIntervals(int[][] intervals) {

        List<int[]> list = new LinkedList<>();
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
