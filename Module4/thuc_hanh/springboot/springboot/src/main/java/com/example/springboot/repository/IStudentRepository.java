package com.example.springboot.repository;

import com.example.springboot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findAll(Pageable pageable);
}
