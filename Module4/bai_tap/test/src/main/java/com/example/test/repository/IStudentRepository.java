package com.example.test.repository;

import com.example.test.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IStudentRepository extends JpaRepository<Student,Long> {

    Page<Student> findAll(Pageable pageable);
    @Query("select p from Student p where p.ten like %?1%")
    Page<Student>searchStudent(Pageable pageable, String name);

}
