package com.example.spring_boot.repository;


import com.example.spring_boot.model.CodeGymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeGymClassRepository extends JpaRepository<CodeGymClass,Long> {
}
