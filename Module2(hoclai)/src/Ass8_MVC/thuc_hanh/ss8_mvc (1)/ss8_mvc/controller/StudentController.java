package ss8_mvc.controller;

import ss8_mvc.service.IStudentService;
import ss8_mvc.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    public static void displayMenu(){
        IStudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        boolean flag=true;
        do {
            System.out.println("Chọn chức năng :");
            System.out.println("1.Display" +
                    "\n 2.Add" +
                    "\n 3.Edit" +
                    "\n 4.Delete" +
                    "\n 5.Exit"
            );
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("Code chức năng hiển thị");
                    studentService.display();
                    break;
                case 2:
                    System.out.println("Code chức năng thêm mới");
                    studentService.add();
                    break;
                case 3:
                    System.out.println("Code chức năng sửa");
                    break;
                case 4:
                    System.out.println("Code chức năng xoá");
                    studentService.delete();
                    break;
                default:
                    flag = false;
            }
        }while (flag);

    }
}
