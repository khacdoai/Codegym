package ss8_mvc.thuc_hanh.repository.impl;

import ss8_mvc.thuc_hanh.model.Student;
import ss8_mvc.thuc_hanh.repository.IStudentRepository;

public class StudentRepository implements IStudentRepository {
    private static ss8_mvc.thuc_hanh.model.Student[]  students = new ss8_mvc.thuc_hanh.model.Student[20];
    static {
        students[0]= new ss8_mvc.thuc_hanh.model.Student(1,"chanh1","C05");
        students[1]= new ss8_mvc.thuc_hanh.model.Student(2,"chanh2","C05");
        students[2]= new ss8_mvc.thuc_hanh.model.Student(3,"chanh3","C05");
    }
    @Override
    public ss8_mvc.thuc_hanh.model.Student[] getListStudent() {
        // đọc ghi file ở đây hoặc kết nối DB

        return students;
    }

    @Override
    public void addStudent(Student student) {
        for (int i=0; i< students.length;i++){
            if (students[i]==null){
                students[i]= student;
                break;
            }
        }

    }

    @Override
    public void deleteStudentById(int id) {
        for (int i=0; i< students.length;i++){
           if (students[i].getId()==id){
               students[i] = null;
               break;
           }
        }

    }
}
