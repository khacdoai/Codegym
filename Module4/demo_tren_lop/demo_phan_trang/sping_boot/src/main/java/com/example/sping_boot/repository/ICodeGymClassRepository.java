package com.example.sping_boot.repository;

import com.example.sping_boot.model.CodeGymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeGymClassRepository extends JpaRepository<CodeGymClass,Long> {
}
