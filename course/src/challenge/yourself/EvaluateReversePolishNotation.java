package challenge.yourself;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(rpn(new String[]{"2", "5", "*", "4", "+", "3", "2", "*", "1", "+", "/"}));
    }

    public static int rpn(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isOperator(token)) {
                int secondNumber = stack.pop();
                int firstNumber = stack.pop();
                stack.push(calculate(token, firstNumber, secondNumber));
            } else {
                int sign = 1;
                if (token.startsWith("-")) {
                    sign = -1;
                    token = token.substring(1);
                }
                int number = Integer.parseInt(token)*sign;
                stack.push(number);
            }
        }

        return stack.peek();
    }


    private static boolean isOperator(String s) {
        return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
    }

    private static int calculate(String operator, int first, int second) {
        if (operator.equals("*")) {
            return first * second;
        } else if (operator.equals("/")) {
            return first / second;
        } else if (operator.equals("+")) {
            return first + second;
        } else if (operator.equals("-")){
            return first - second;
        } else {
            return -1;
        }
    }
}
