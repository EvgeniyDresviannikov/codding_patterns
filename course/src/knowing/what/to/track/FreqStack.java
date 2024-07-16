package knowing.what.to.track;

import java.util.*;

public class FreqStack {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        System.out.println(freqStack.pop());
        freqStack.push(4);
        freqStack.push(1);
        System.out.println(freqStack.pop());
    }

    private HashMap<Integer, Stack<Integer>> freqToStack = new HashMap<>();
    private HashMap<Integer, Integer> valueToFreq = new HashMap<>();
    private int maxFrequency = 1;


    public FreqStack() {
        freqToStack.put(1, new Stack<>());
    }

    public void push(int val) {
        if (valueToFreq.containsKey(val)) {
            int freq = valueToFreq.get(val);
            int newfreq = freq + 1;
            valueToFreq.put(val, newfreq);
            maxFrequency = Math.max(maxFrequency, newfreq);
            if (freqToStack.containsKey(newfreq)) {
                Stack<Integer> stack = freqToStack.get(newfreq);
                stack.push(val);
            } else {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                freqToStack.put(newfreq, stack);
            }
        } else {
            valueToFreq.put(val, 1);
            freqToStack.get(1).push(val);
            maxFrequency = maxFrequency == 0 ? 1 : maxFrequency;
        }
    }

    public int pop() {
        Stack<Integer> stack = freqToStack.get(maxFrequency);
        if (stack == null || stack.isEmpty()) return -1;

        int pop = stack.pop();

        valueToFreq.put(pop, valueToFreq.get(pop)-1);
        if (stack.isEmpty()) {
            maxFrequency--;
        }

        return pop;
    }
}


