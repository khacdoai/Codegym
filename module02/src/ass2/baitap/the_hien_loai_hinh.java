package ass2.baitap;

import java.util.Scanner;

public class the_hien_loai_hinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = scanner.nextInt();
        for (int i = 1; i<= n; i++){
            System.out.print("* ");
            for (int j = 1; j < i;j++){
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
}
