package stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("azbbzybaab"));
    }

    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().equals(currentChar)) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }

        }

        return stack.stream().map(Object::toString).collect(Collectors.joining());
    }
}
