package stack;

import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

class Pair {
    Character c;
    Integer index;

    public Pair(Character c, Integer index) {
        this.c = c;
        this.index = index;
    }
}

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        System.out.println(minRemoveParentheses("(((abc)(to)((q)()("));
    }

    public static String minRemoveParentheses(String s) {

        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new Pair(c, i));
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek().c == '(') {
                    stack.pop();
                } else {
                    stack.push(new Pair(c, i));
                }
            }
        }

        Set<Integer> toRemove = stack.stream().map(pair -> pair.index).collect(Collectors.toSet());

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
