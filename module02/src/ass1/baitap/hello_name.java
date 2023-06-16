package ass1.baitap;

import java.util.Scanner;

public class hello_name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Etren your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello :" + name);
    }
}
