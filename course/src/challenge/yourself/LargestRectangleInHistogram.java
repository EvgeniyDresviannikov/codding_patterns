package challenge.yourself;

import java.util.Map;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangle(new int[] {6,2,5,4,5,1,6,4,2}));
    }

    public static int largestRectangle(int[] heights) {

        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        int maxResult = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int prevIndex = i;
            while (!stack.isEmpty() && stack.peek().getKey() > height) {
                Map.Entry<Integer, Integer> pop = stack.pop();
                prevIndex = pop.getValue();
                int area = pop.getKey() * (i - prevIndex);
                maxResult = Math.max(maxResult, area);
            }
            if (stack.isEmpty() || stack.peek().getKey() != height) {
                stack.push(Map.entry(height, prevIndex));
            }
        }

        while (!stack.isEmpty()) {
            Map.Entry<Integer, Integer> pop = stack.pop();
            int area = pop.getKey() * (heights.length - pop.getValue());
            maxResult = Math.max(maxResult, area);
        }

        return maxResult;
    }
}
