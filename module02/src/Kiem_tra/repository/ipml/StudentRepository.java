package Kiem_tra.repository.ipml;

import Kiem_tra.common.ReadWriteFile;
import Kiem_tra.model.Student;
import Kiem_tra.repository.IStudentRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepository implements IStudentRepository {
    public static final String SRC_STUDENT = "src/kiemtra/data/StudentAndTeacher.csv";
    public void remove(int code) {
        List<Student> students = getAll();
        for (Student student: students) {
            if(student.getCode() == code) {
                System.out.println("Bạn có muốn xóa student có code là: "+ code);
                System.out.println("1. Đồng ý");
                System.out.println("2. Hủy bỏ");
                int choice = Integer.parseInt(new Scanner(System.in).nextLine());
                if(choice == 1) {
                    students.remove(student);
                    String str = "";
                    for(Student temp: students) {
                        str+=convertToString(temp)+"\n";
                    }
                    str = str.substring(0, str.length()-3);
                    ss16.mvc.common.ReadWriteFile.writeFile(SRC_STUDENT,str,false);
                    System.out.println("Xóa thành công");
                }
                break;
            }
        }


    }

    @Override
    public void add(Student student) {
        ReadWriteFile.writeFile(SRC_STUDENT, convertToString(student), true);

    }


    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        List<String> strings = ReadWriteFile.readFile(SRC_STUDENT);
        String[] temp;
        for (String str : strings) {
            temp = str.split(",");

            students.add(new Student(temp[0]),temp[1] , temp[2], temp[3], temp[4],temp[5],);
        }
        return students;
    }

    private String convertToString(Student student) {
        return student.getCode() + "," + student.getName() + "," + student.getDateOfBirth() + "," + student.getGioitinh()+ "," + student.getPhone() ;
    }

}
