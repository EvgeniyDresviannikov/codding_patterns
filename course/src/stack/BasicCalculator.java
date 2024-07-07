package stack;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculator("12 - (6+2)+5"));
    }

    public static int calculator(String s) {

        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int cur = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                cur = cur*10+Character.getNumericValue(c);
            } else if (c == '+' || c == '-') {
                res += sign*cur;
                cur = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign*cur;
                int prevSign = stack.pop();
                int prevRes = stack.pop();
                res = prevRes + res*prevSign;
                cur = 0;
            }
        }

        return res + sign*cur;
    }
}
