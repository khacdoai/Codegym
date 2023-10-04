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
            System.out.println("Chọn chức năng : ");
            System.out.println("1. Hiển thị danh sách nhân viên" +
                    "\n 2. Thêm nhân viên" +
                    "\n 3. Chỉnh sửa thông tin nhân viên"+
                    "\n 4. Xóa Khách hàng " +
                    "\n 5. Tìm kiếm khách hàng theo tên"+
                    "\n 6. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Hiển thị danh sách khách hàng");
                    emloyeeService.EmloyeeDisplay();
                    break;
                case 2:
                    System.out.println(" 2. Thêm khách hàng");
                    break;
                case 3:
                    System.out.println("3. Chỉnh sửa thông tin khách hàng");
                    break;
                case 4:
                    System.out.println("4. Xóa Khách hàng");
                    break;
                case 5:
                    System.out.println("5. Tìm kiếm khách hàng theo tên");
                    break;
                case 6:
                    flag = false;
            }
        }while (flag);
    }
}
