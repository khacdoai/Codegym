package com.example.sping_boot.repository;
import com.example.sping_boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
//    @Query(nativeQuery = true, value = "select * from student")
//    List<Student> showList();
}
