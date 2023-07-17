package ass11.baitap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi vao:");
        String n = sc.nextLine();
        String arr[] = n.split("");
        boolean check = true;
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            queue.offer(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            String s1 = stack.pop();
            String s2 = queue.poll();
            if (!s1.equalsIgnoreCase(s2)) {
                check = false;
                break;
            } else {
                check = true;
            }
        }
        if (check) {
            System.out.println("true");
        } else {
            System.out.println("False");
        }

    }
}
