package case_study.controller;

import case_study.service.IEmloyeeService;
import case_study.service.impl.EmployeeService;

import java.util.Scanner;

public class PromotionControler {
    public static void displaymenu(){
        IEmloyeeService emloyeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Chon chuc nang : ");
            System.out.println("1. Display list customers use service" +
                    "\n 2. Display list customers get voucher" +
                    "\n 3. Return main menu");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Display list customers use service");
                    break;
                case 2:
                    System.out.println(" 2. Display list customers get voucher");
                    emloyeeService.EmloyeeAdd();
                    break;
                case 3:
                    flag = false;
            }
        }while (flag);
    }
}
