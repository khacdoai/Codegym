package ss8_mvc.thuc_hanh.repository;

import ss8_mvc.thuc_hanh.model.Student;

public interface IStudentRepository {
    Student[] getListStudent();
    void addStudent(Student student);
    void deleteStudentById(int id);
}
