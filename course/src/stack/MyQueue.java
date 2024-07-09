package stack;

import java.util.Stack;



public class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.pop()); // 1
        System.out.println(myQueue.peek()); // 2
        myQueue.push(3);
        System.out.println(myQueue.peek()); // 2
        System.out.println(myQueue.pop()); // 2
        System.out.println(myQueue.pop()); // 3
    }

    public MyQueue() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();

    }

    public void push(int x) {
        while (!popStack.empty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }

    public int pop() {

        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    public int peek() {

        while (!pushStack.empty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    public boolean empty() {

       return pushStack.isEmpty() && popStack.empty();
    }
}
