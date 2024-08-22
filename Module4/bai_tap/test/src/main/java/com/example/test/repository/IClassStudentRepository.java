package com.example.test.repository;

import com.example.test.model.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassStudentRepository extends JpaRepository<ClassStudent,Long> {

}
