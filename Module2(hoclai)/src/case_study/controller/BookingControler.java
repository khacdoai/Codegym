package case_study.controller;

import case_study.service.ICustomerService;
import case_study.service.impl.CustomerService;

import java.util.Scanner;

public class BookingControler {
    public static void displaymenu(){
        ICustomerService customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Chon chuc nang : ");
            System.out.println("1.Add new booking" +
                    "\n 2. Display list booking" +
                    "\n 3. Create new contracts"+
                    "\n 4. Display list contracts " +
                    "\n 5. Edit contracts "+
                    "\n 6. Return main menu");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Add new booking");
                    customerService.display();
                    break;
                case 2:
                    System.out.println(" 2. Display list booking");
                    customerService.add();
                    break;
                case 3:
                    System.out.println("3. Create new contracts");
                    customerService.update();
                    break;
                case 4:
                    System.out.println("4. Display list contracts");
                    customerService.delete();
                    break;
                case 5:
                    System.out.println("5. Edit contracts");
                    customerService.search();
                    break;
                case 6:
                    flag = false;
            }
        }while (flag);
    }
}
