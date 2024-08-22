package com.example.demo_bai_1.repository;

import com.example.demo_bai_1.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Repository
public class StudentRepository implements IStudentRepository {
    public static List<Student> list = new ArrayList<>();
    static {
        list.add(new Student(1,"Vo Van A","vovana@gmail.com","hue"));
        list.add(new Student(2,"Vo Van B","vovanb@gmail.com","Quang Tri"));
        list.add(new Student(3,"Vo Van C","vovanc@gmail.com","Quang Binh"));
        list.add(new Student(4,"Pham Thi D","phamthid@gmail.com","Da Nang"));
        list.add(new Student(5,"Nguyen Thi E","nguyenthie@gmail.com","Quang nôm"));
        list.add(new Student(6,"Huynh Van F","huynhvanf@gmail.com","Nghe An"));
    }
    @Override
    public List<Student> showList() {
        return list;
    }

    @Override
    public Student selectStudent(int id) {
        for (Student student : list){
            if(student.getId() == id){
                return student;

            }
        }
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        Iterator<Student> iterator = list.listIterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if(student.getId() == id){
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void updateStudent(int id, Student student) {
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                Student updateStudent = list.get(i);
                updateStudent.setTen(student.getTen());
                updateStudent.setEmail(student.getEmail());
                updateStudent.setDiaChi(student.getDiaChi());
                break;
            }
        }
    }

    @Override
    public void createStudent(Student student) {
        list.add(student);
    }

    @Override
    public List<Student> searchStudent(String name) {
        List<Student> studentList = new ArrayList<>();

        String searchName  = name.toLowerCase(Locale.ROOT);

        for (Student student: list){
            String studentName  =student.getTen().toLowerCase(Locale.ROOT);
            if(studentName.contains(searchName)){
                studentList.add(student);
            }
        }
        return studentList;
    }


}
