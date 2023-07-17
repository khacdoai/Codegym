package ass11.baitap;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> numberStack = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên cần chuyển :");
        String number = sc.nextLine();
        int num = Integer.parseInt(number);
        for(; num >0; ) {
            int temp = num%2;
            numberStack.push(temp);
            num = num/2;
        }
        System.out.println("Dãy nhị phân : ");
        for(;!numberStack.isEmpty();) {
            System.out.print(numberStack.pop());
        }
        sc.close();
    }
}
