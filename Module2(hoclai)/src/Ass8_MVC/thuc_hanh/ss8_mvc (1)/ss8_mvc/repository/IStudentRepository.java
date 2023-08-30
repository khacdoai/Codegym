package ss8_mvc.repository;

import ss8_mvc.model.Student;

public interface IStudentRepository {
    Student[] getListStudent();
    void addStudent(Student student);
    void deleteStudentById(int id);
}
