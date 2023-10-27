package case_study.controller;

import case_study.service.ICustomerService;
import case_study.service.impl.CustomerService;

import java.util.Scanner;

public class CustomerControler {
    public static void displaymenu(){
        ICustomerService customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Chon chuc nang : ");
            System.out.println("1.Display list customers" +
                    "\n 2. Add new customers" +
                    "\n 3. Edit customers"+
                    "\n 4. Delete customers " +
                    "\n 5. Search customers by name "+
                    "\n 6. Return main menu");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Display list customers");
                    customerService.display();
                    break;
                case 2:
                    System.out.println(" 2. Add new customers");
                    customerService.add();
                    break;
                case 3:
                    System.out.println("3. Edit customers");
                    customerService.update();
                    break;
                case 4:
                    System.out.println("4. Delete customers");
                    customerService.delete();
                    break;
                case 5:
                    System.out.println("5. Search customers by name");
                    customerService.search();
                    break;
                case 6:
                    flag = false;
            }
        }while (flag);
    }


}
