package thi.controller;



import thi.service.impl.BenhAnService;

import java.util.Scanner;

public class BenhAnController {
    public static void displaymenu(){
        BenhAnService benhAnService = new BenhAnService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Chon chuc nang theo so (de tiep tuc): ");
            System.out.println(" 1.Them moi" +
                    "\n 2. Xoa" +
                    "\n 3. Xem danh sach benh an"+
                    "\n 4. thoat" );
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. them moi ");
                    benhAnService.themmoi();
                    break;
                case 2:
                    System.out.println(" 2. Xoa");
                    benhAnService.xoa();
                    break;
                case 3:
                    System.out.println("3. Xem danh sach cac benh an");
                    benhAnService.hienthi();
                    break;

                case 4:
                    flag = false;
            }
        }while (flag);
    }
}
