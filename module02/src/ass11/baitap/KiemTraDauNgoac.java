package ass11.baitap;

import java.util.Stack;

public class KiemTraDauNgoac {
    public static void main(String[] args) {
        String string1 = "s * ( s – a) * (s – b) * (s – c)";
        String string2 = "s * ( s – a) * (s – b * (s – c)";
        System.out.println(checkNgoac(string1));
        System.out.println(checkNgoac(string2));
    }

    private static boolean checkNgoac(String str1) {
        Stack<String> stackChar = new Stack<String>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '(' || str1.charAt(i) == ')') {
                if (str1.charAt(i) == ')') {
                    if (stackChar.isEmpty()) {
                        return false;
                    } else if (stackChar.peek().equals("(")) {
                        stackChar.pop();
                    } else {
                        return false;
                    }
                } else {
                    String s = String.valueOf(str1.charAt(i));
                    stackChar.push(s);
                }
            }
        }
        if (!stackChar.isEmpty()) {
            return false;
        }
        return true;
    }
}
