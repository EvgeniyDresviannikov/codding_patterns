package backtracking;

import java.util.Arrays;
import java.util.Collections;

public class MatchSticksToSquare {

    static int sideLength = 0;
    static int[] sortedNums = new int[]{};
    static int[] square = new int[]{0,0,0,0};

    public static void main(String[] args) {
        System.out.println(matchstickToSquare(new int[]{1,1,2,2,2}));
    }

    public static boolean matchstickToSquare(int[] nums) {

        if (nums.length < 4) return false;

        int sum = Arrays.stream(nums).sum();

        if (sum % 4 > 0) return false;

        sideLength = sum / 4;

        sortedNums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        if (sortedNums[0] > sideLength) return false;

        return backtrack(0, 0);
    }

    private static boolean backtrack(int sideIndex, int index) {
        if (index == sortedNums.length-1 && square[sideIndex] + sortedNums[index] == sideLength) {
            return true;
        }

        int currSide = square[sideIndex] + sortedNums[index];
        if (currSide > sideLength) return false;

        square[sideIndex] = currSide;
        for (int side = 0; side < square.length; side++) {

            if (backtrack(side, index+1)) return true;
        }

        square[sideIndex] = square[sideIndex] - sortedNums[index];

        return false;
    }
}
