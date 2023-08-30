package Kiem_tra.controller;

import Kiem_tra.service.IStudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    public static void menu() {
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa ");
        System.out.println("3. Xem danh sách sinh viên");
        System.out.println("4. Xem thông tin giáo viên ");
        System.out.println("5. Tìm kiếm sinh viên");
        System.out.println("6. Thoát");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nhập không đúng định dạng");
        }
        switch (choice)  {
            case 1:
                IStudentService.addStudent();
                break;
            case 2:
                IStudentService.displayAllStudent();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
