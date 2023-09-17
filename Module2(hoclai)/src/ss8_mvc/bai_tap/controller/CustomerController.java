package ss8_mvc.bai_tap.controller;

import ss8_mvc.bai_tap.service.ICustomerService;
import ss8_mvc.bai_tap.service.impl.CustomerService;

import java.util.Scanner;

public class CustomerController {
    public static void displayMenu() {
        ICustomerService customerService = new CustomerService();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Dislay " +
                    "\n 2. Add " +
                    "\n 3. Delete" +
                    "\n 4. Update" +
                    "\n 5. Search" +
                    "\n 6. Exit");
        int choose = Integer.parseInt(scanner.nextLine());

        switch (choose){
            case 1:
                System.out.println("Chức năng hiển thị ");
                customerService.display();
                break;
            case 2:
                System.out.println("Chức năng thêm mới");
                customerService.add();
                break;
            case 3:
                System.out.println("Chức năng xóa theo ID");
                customerService.delete();
                break;
            case 4:
                System.out.println("Chức năng chỉnh sửa");
                customerService.update();
                break;
            case 5:
                System.out.println("Chức năng tìm kiếm theo tên");
                customerService.search();
                break;
            case 6:
                flag = false;
        }


        } while (flag);
    }
}
