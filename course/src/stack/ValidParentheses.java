package stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{}[]{}[{}])"));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char next = s.charAt(i);

            if (next == '(' || next == '{' || next == '[') {
                stack.push(next);
            } else {
                if (stack.isEmpty()) return false;

                char pop = stack.peek();
                if ( (pop == '(' && next == ')') || (pop == '{' && next == '}') || (pop == '[' && next == ']') )  {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
