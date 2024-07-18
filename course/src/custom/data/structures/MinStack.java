package custom.data.structures;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
        minStack1.push(6);
        minStack1.push(4);
        minStack1.push(3);
        minStack1.push(7);
        minStack1.push(9);

        System.out.println(minStack1.minNumber());

        minStack1.pop();

        System.out.println(minStack1.minNumber());

        minStack1.pop();

        System.out.println(minStack1.minNumber());

        minStack1.pop();

        System.out.println(minStack1.minNumber());
    }


    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Pop() removes and returns value from minStack
    public int pop() {
        if (mainStack.isEmpty()) return -1;

        minStack.pop();
        return mainStack.pop();

    }

    // Pushes values into MinStack
    public void push(Integer value) {
        mainStack.push(value);

        if (minStack.isEmpty()) {
            minStack.push(value);
            return;
        }

        int currentMinValue = minStack.peek();
        if (currentMinValue > value) {
            minStack.push(value);
        } else {
            minStack.push(currentMinValue);
        }
    }

    // returns minimum value in O(1)
    public int minNumber() {

        if (minStack.isEmpty()) return -1;

        return minStack.peek();
    }
}
