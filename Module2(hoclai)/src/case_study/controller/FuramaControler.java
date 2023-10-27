package case_study.controller;

import case_study.service.ICustomerService;
import case_study.service.impl.CustomerService;

import java.util.Scanner;

public class FuramaControler {
    public static void displaymenu(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Chon chuc nang : ");
            System.out.println("1. Employee Management" +
                    "\n 2. Customer Management" +
                    "\n 3. Facility Management"+
                    "\n 4. Booking Management " +
                    "\n 5. Promotion Management"+
                    "\n 6. Thoat");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Employee Management");
                    EmloyeeControler.displaymenu();
                    break;
                case 2:
                    System.out.println(" 2. Customer Management");
                    CustomerControler.displaymenu();
                    break;
                case 3:
                    System.out.println("3. Facility Management");
                    FacilityControler.displaymenu();
                    break;
                case 4:
                    System.out.println("4. Booking Management");
                    BookingControler.displaymenu();
                    break;
                case 5:
                    System.out.println("5. Promotion Management");
                    PromotionControler.displaymenu();
                    break;
                case 6:
                    flag = false;
            }
        }while (flag);
    }


}
