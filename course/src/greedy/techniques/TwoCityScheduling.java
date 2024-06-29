package greedy.techniques;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    public static void main(String[] args) {
        System.out.println(twoCityScheduling(new int[][]{ {1,2}, {2,1}, {1,3}, {4,1} }));
    }

    public static int twoCityScheduling(int[][] costs) {

        Arrays.sort(costs, Comparator.comparingInt(o -> (o[0] - o[1])));

        int totalCost = 0;
        int index = 0;

        while (index < costs.length/2) {
            totalCost += costs[index][0];
            index++;
        }

        while (index < costs.length) {
            totalCost += costs[index][1];
            index++;
        }

        return totalCost;
    }
}
