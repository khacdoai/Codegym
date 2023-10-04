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
            System.out.println("Chọn chức năng : ");
            System.out.println("1. Hiển thị danh sách khách hàng" +
                    "\n 2. Thêm khách hàng" +
                    "\n 3. Chỉnh sửa thông tin khách hàng"+
                    "\n 4. Xóa Khách hàng " +
                    "\n 5. Tìm kiếm khách hàng theo tên"+
                    "\n 6. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Hiển thị danh sách khách hàng");
                    customerService.display();
                    break;
                case 2:
                    System.out.println(" 2. Thêm khách hàng");
                    customerService.add();
                    break;
                case 3:
                    System.out.println("3. Chỉnh sửa thông tin khách hàng");
                    customerService.update();
                    break;
                case 4:
                    System.out.println("4. Xóa Khách hàng");
                    customerService.delete();
                    break;
                case 5:
                    System.out.println("5. Tìm kiếm khách hàng theo tên");
                    customerService.search();
                    break;
                case 6:
                    flag = false;
            }
        }while (flag);
    }


}
