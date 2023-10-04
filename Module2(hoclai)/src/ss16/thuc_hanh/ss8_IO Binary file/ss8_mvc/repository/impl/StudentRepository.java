package ss8_mvc.repository.impl;

import ss8_mvc.model.CompaById;
import ss8_mvc.model.Student;
import ss8_mvc.repository.IStudentRepository;
import ss8_mvc.util.ReadAndWrite;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String PATH_STUDENT ="D:\\codegym\\demo2023\\module2\\A0523I1\\module2\\src\\ss8_mvc\\data\\student.csv";
    private final String PATH_STUDENT_DAT ="D:\\codegym\\demo2023\\module2\\A0523I1\\module2\\src\\ss8_mvc\\data\\student.dat";

    @Override
    public List<Student> getListStudent() {
        List<Student> studentList = new ArrayList<>();
        // đọc  file ở đây hoặc kết nối DB
        List<String> stringList = ReadAndWrite.readCSVFile(PATH_STUDENT);
        // chuyển thành list student
        String[] array = null;
        for (String string: stringList) {
            array = string.split(",");
            Student student = new Student(Integer.parseInt(array[0]),array[1],array[2]);
            studentList.add(student);
        }
//        studentList = ReadAndWrite.readObjecListStudent(PATH_STUDENT_DAT);
        return studentList;
    }

    @Override
    public List<Student> searchByName(String searchName) {
        List<Student> studentList = getListStudent();
        List<Student> searchList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().contains(searchName)){
                searchList.add(studentList.get(i));
            }
        }
        return searchList;
    }

    @Override
    public void addStudent(Student student) {
        List<String> stringList = new ArrayList<>();
        stringList.add(student.getInfoToCSV());
        ReadAndWrite.writeToCSV(PATH_STUDENT,stringList,true);
//        List<Student> studentList = new ArrayList<>();
//        studentList = ReadAndWrite.readObjecListStudent(PATH_STUDENT_DAT);
//        studentList.add(student);
//        ReadAndWrite.writeListObjectToCSV(PATH_STUDENT_DAT,studentList);
    }

    @Override
    public void edit(int id, Student newStudent) {
        boolean check = false;
        List<Student> studentList = getListStudent();
        for (int i = 0; i <studentList.size() ; i++) {
            if (studentList.get(i).getId()==id){
                studentList.get(i).setName(newStudent.getName());
                studentList.get(i).setClassName(newStudent.getClassName());
                check =true;
                break;
            }
        }
        if (check){
            List<String> stringList = new ArrayList<>();
            for (Student student: studentList) {
                stringList.add(student.getInfoToCSV());
            }
            ReadAndWrite.writeToCSV(PATH_STUDENT,stringList,false);
        }else {
            System.out.println("không tìm thấy id");
        }

    }

    @Override
    public void deleteStudentById(int id) {
     List<Student> studentList = getListStudent();
        for (int i = 0; i <studentList.size() ; i++) {
            if (studentList.get(i).getId()==id){
                studentList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Student student: studentList) {
            stringList.add(student.getInfoToCSV());
        }
        ReadAndWrite.writeToCSV(PATH_STUDENT,stringList,false);

    }

    @Override
    public Student findById(int id) {
        List<Student> studentList = getListStudent();
        for (int i = 0; i <studentList.size() ; i++) {
            if (studentList.get(i).getId()==id){
                return  studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Student> sortByClassName() {
        // sắp xếp theo class name
        return null;
    }
}
