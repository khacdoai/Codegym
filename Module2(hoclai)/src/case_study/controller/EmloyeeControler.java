package case_study.controller;


import case_study.service.IEmloyeeService;

import case_study.service.impl.EmployeeService;

import java.util.Scanner;

public class EmloyeeControler {
    public static void displaymenu(){
        IEmloyeeService emloyeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Chon chuc nang : ");
            System.out.println("1. Display list employees" +
                    "\n 2. Add new employee" +
                    "\n 3. Edit employee"+
                    "\n 4. Delete employee " +
                    "\n 5. Search employee by name "+
                    "\n 6. Return main menu");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Display list employees");
                    emloyeeService.EmloyeeDisplay();
                    break;
                case 2:
                    System.out.println(" 2. Add new employee");
                    emloyeeService.EmloyeeAdd();
                    break;
                case 3:
                    System.out.println("3. Edit employee");
                    emloyeeService.EmloyeeUpdate();
                    break;
                case 4:
                    System.out.println("4. Delete employee");
                    emloyeeService.EmloyeeDelete();
                    break;
                case 5:
                    System.out.println("5. Search employee by name");
                    emloyeeService.EmloyeeSearch();
                    break;

                case 6:
                    flag = false;
            }
        }while (flag);
    }
}
