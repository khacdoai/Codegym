package case_study.controller;

import case_study.service.IEmloyeeService;
import case_study.service.impl.EmployeeService;

import java.util.Scanner;

public class FacilityControler {
    public static void displaymenu(){
        IEmloyeeService emloyeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Chon chuc nang : ");
            System.out.println("1. Display list facility" +
                    "\n 2. Add new facility" +
                    "\n 3. Display list facility maintenance"+
                    "\n 4. Return main menu");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Display list facility");
                    break;
                case 2:
                    System.out.println(" 2. Add new facility");
                    emloyeeService.EmloyeeAdd();
                    break;
                case 3:
                    System.out.println("3. Display list facility maintenance");
                    emloyeeService.EmloyeeUpdate();
                    break;
                case 4:
                    flag = false;
            }
        }while (flag);
    }
}
