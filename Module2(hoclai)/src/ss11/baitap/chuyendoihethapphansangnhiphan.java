package ss11.baitap;

import java.util.Scanner;
import java.util.Stack;

public class chuyendoihethapphansangnhiphan {
    public static String chuyendoihethapphansangnhiphan(int thapphan){
        if (thapphan == 0){
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        int phandu = 0;
        while (thapphan > 0){
            phandu = thapphan % 2;
            stack.push(phandu);
            thapphan /=2;
        }
        StringBuilder soNhiPhan = new StringBuilder();
        while (!stack.isEmpty()){
            soNhiPhan.append(stack.pop());
        }
        return soNhiPhan.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thập phân");
        int thapphan = Integer.parseInt(scanner.nextLine());
        String sonhiphan = chuyendoihethapphansangnhiphan(thapphan);
        System.out.println("Số nhị phân\n" + sonhiphan);

    }
}
