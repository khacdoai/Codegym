package com.example.thi.service;

import com.example.thi.modell.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IDuAnService {
    Page<DuAn> showList(Pageable pageable);
    void create(DuAn duAn);
    Page<DuAn> searchByName(Pageable pageable, String name);
    Page<DuAn> searchByNameAndDate(Pageable pageable, String name, String startDate, String endDate);

}
