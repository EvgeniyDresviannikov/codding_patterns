package challenge.yourself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,2,1,-2})));
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int val = asteroids[i];
            if (stack.isEmpty()
                    || (stack.peek() > 0 && val > 0)
                    || (stack.peek() < 0 && val < 0)
                    || (stack.peek() < 0 && val > 0)
            ) {
                stack.push(val);
            } else if (stack.peek().equals(Math.abs(val))) {
                stack.pop();
            } else  {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(val)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek().equals(Math.abs(val))) {
                    stack.pop();
                    continue;
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(val);
                }

            }


        }

        return new ArrayList<>(stack).stream().mapToInt(i ->i).toArray();
    }
}
