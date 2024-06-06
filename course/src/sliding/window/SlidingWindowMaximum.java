package sliding.window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4))); // 7,7,7,7,7
    }

    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        Deque<Integer> maxKeeper = new ArrayDeque<>();
        int[] result = new int[nums.length-w+1];

        for (int i = 0; i < w; i++) {
            if (maxKeeper.isEmpty()) {
                maxKeeper.offerFirst(i);
            } else {
                while (maxKeeper.peekFirst() != null && nums[maxKeeper.peekFirst()] < nums[i]) {
                    maxKeeper.pollFirst();
                }
                maxKeeper.offerFirst(i);
            }
        }

        result[0] = nums[maxKeeper.peekLast()];

        for (int i = w; i < nums.length; i++) {
            int oldIndex = i-w;
            if (maxKeeper.peekLast() <= oldIndex) {
                maxKeeper.pollLast();
            }
            while (maxKeeper.peekFirst() != null && nums[maxKeeper.peekFirst()] < nums[i]) {
                maxKeeper.pollFirst();
            }
            maxKeeper.offerFirst(i);
            result[i-w+1] = nums[maxKeeper.peekLast()];
        }

        return result;
    }
}
