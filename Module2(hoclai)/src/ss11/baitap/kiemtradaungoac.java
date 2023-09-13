package ss11.baitap;

import java.util.Scanner;
import java.util.Stack;

public class kiemtradaungoac {
    public static boolean kiemtradaungoac(String bieuthuc){
        Stack<Character> stack = new Stack<>();
        for (char kitu : bieuthuc.toCharArray()){
            if (kitu == '[' || kitu == '(' || kitu == '{'){
                stack.push(kitu);
            }
            else if(kitu == ']' || kitu == ')' || kitu == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char kitudong = stack.pop();
                if (!kiemtradongmo(kitu, kitudong)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean kiemtradongmo(char open, char close){
        return open == '(' && close == ')' ||
                open == '[' && close == ']' ||
                open == '{' && close == '}';
    }

    public static void main(String[] args) {
        String ex = "s * (s – a) * (s – b) * (s – c)";
        String expression2 = "(- b + (b2 – 4*a*c)^0.5) / 2*a";
        System.out.println(ex + "is balanced: " + kiemtradaungoac(ex));
        System.out.println(expression2 + "is balanced: " + kiemtradaungoac(expression2));
    }
}
