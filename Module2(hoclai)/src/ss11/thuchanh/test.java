package ss11.thuchanh;

import java.util.Stack;

public class test {
    public static boolean isBracketBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char symbol : expression.toCharArray()) {
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
            } else if (symbol == ')' || symbol == ']' || symbol == '}') {
                if (stack.isEmpty()) {
                    return false; // Không có dấu mở tương ứng
                }
                char top = stack.pop();
                if (!isMatchingPair(top, symbol)) {
                    return false; // Dấu đóng không khớp với dấu mở
                }
            }
        }

        return stack.isEmpty(); // Nếu stack rỗng thì biểu thức đúng
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String expression1 = "s * (s – a) * (s – b) * (s – c)";
        String expression2 = "(- b + (b2 – 4*a*c)^0.5) / 2*a";
        String expression3 = "s * (s – a) * s – b) * (s – c)";

        System.out.println(expression1 + " is balanced: " + isBracketBalanced(expression1));
        System.out.println(expression2 + " is balanced: " + isBracketBalanced(expression2));
        System.out.println(expression3 + " is balanced: " + isBracketBalanced(expression3));
    }
}
