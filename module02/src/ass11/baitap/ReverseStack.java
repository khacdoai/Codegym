package ass11.baitap;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<String> numberStack = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mảng số nguyên (cách mỗi phần tử bằn dấu ,) :");
        String numbers = sc.nextLine();
        String[] numberArray =  numbers.split(",");
        for(int i = 0;i<numberArray.length;i++) {
            numberStack.push(numberArray[i]);
        }
        for(int i = 0;i<numberArray.length;i++) {
            numberArray[i]= numberStack.pop();
        }
        System.out.println("Dãy đảo ngược là : ");
        System.out.print(String.join(",", numberArray));
        sc.close();
    }
}
