package ss11.baitap;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

public class kiemtrachuoiPalindromesudungqueue {
    public static boolean Palindrome(String chuoi){
        chuoi = chuoi.replaceAll("\\s","").toLowerCase(Locale.ROOT);
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char e : chuoi.toCharArray()){
            queue.add(e);
            stack.push(e);
        }
        while (!queue.isEmpty() && !stack.isEmpty()){
            char charqueue = queue.remove();
            char charStack = stack.pop();
            if (charqueue != charStack){
                return false;
            }
        }
        return queue.isEmpty() && stack.isEmpty();
    }

    public static void main(String[] args) {
        String chuoi1 = "Able was I ere I saw Elba";
        System.out.println("is a palindrome:" + Palindrome(chuoi1));
    }
}
