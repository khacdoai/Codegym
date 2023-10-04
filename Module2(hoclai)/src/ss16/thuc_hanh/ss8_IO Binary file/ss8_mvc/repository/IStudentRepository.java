package ss8_mvc.repository;

import ss8_mvc.model.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface IStudentRepository {
    List<Student> getListStudent();
    List<Student> searchByName(String searchName);
    List<Student> sortByClassName();
    void addStudent(Student student);
    void edit(int id, Student newStudent);
    void deleteStudentById(int id);
    Student findById(int id);
}
