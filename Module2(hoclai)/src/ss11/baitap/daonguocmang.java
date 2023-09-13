package ss11.baitap;

import java.util.Scanner;
import java.util.Stack;

public class daonguocmang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = new int[10];
        System.out.println("Nhập các phần tử của mảng gồm 10 Phần tử");
        for (int i = 0; i < n.length;i++ ){
            System.out.println("Nhập phần tử thứ " + (i+1));
            n[i] = Integer.parseInt(scanner.nextLine());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i =0; i<n.length;i++){
            stack.push(n[i]);
        }
        System.out.println(stack);
        for (int i =0; i<n.length;i++){
            n[i] = stack.pop();
        }
        for (int i =0; i<n.length;i++){
            stack.push(n[i]);
        }
        System.out.println(stack);

    }
}
