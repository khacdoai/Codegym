package com.example.thi.repository;

import com.example.thi.modell.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface IDuAnRepository extends JpaRepository<DuAn,Long> {
    Page<DuAn> findAll(Pageable pageable);

    @Query("select p from DuAn p where p.tenDuAn like %?1%")
    Page<DuAn>searchStudent(Pageable pageable, String name);
    @Query("select p from DuAn p where p.tenDuAn like %:name% and p.ngayDangKi between :startDate and :endDate")
    Page<DuAn> findByNameContainingAndDateBetween(Pageable pageable, String name, String startDate, String endDate);
    @Query("select p from DuAn p where p.ngayDangKi between :startDate and :endDate")
    Page<DuAn> findByDateBetween(Pageable pageable, String startDate, String endDate);


}
