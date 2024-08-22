package com.example.springboot.repository;

import com.example.springboot.model.CodeGymClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeGymClassRepository extends JpaRepository<CodeGymClass,Long> {
}
