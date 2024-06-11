package merge.intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersection {

    public static void main(String[] args) {
        int[][] result = intervalsIntersection(new int[][]{ {2,6}, {7,9}, {10,13}, {14, 19}, {20,24} }, new int[][]{ {1,4}, {6,8}, {15,18} });

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {

        List<int[]> result = new LinkedList<>();

        int i = 0;
        int j = 0;

        while (i < intervalLista.length && j < intervalListb.length) {
            int latestStartingTime = Math.max(intervalLista[i][0], intervalListb[j][0]);
            int earliestEndTime = Math.min(intervalLista[i][1], intervalListb[j][1]);
            if (latestStartingTime <= earliestEndTime) {
                result.add(new int[] {latestStartingTime, earliestEndTime});
            }
            if (intervalLista[i][1] < intervalListb[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[][]{});
    }
}
