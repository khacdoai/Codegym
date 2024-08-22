package com.example.thi.service;

import com.example.thi.modell.DuAn;
import com.example.thi.repository.IDuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class duAnService implements IDuAnService{
    @Autowired
    IDuAnRepository iDuAnRepository;

    @Override
    public Page<DuAn> showList(Pageable pageable) {
        return iDuAnRepository.findAll(pageable);
    }

    @Override
    public void create(DuAn duAn) {
        iDuAnRepository.save(duAn);
    }

    @Override
    public Page<DuAn> searchByName(Pageable pageable, String name) {
        return iDuAnRepository.searchStudent(pageable,name);
    }

    @Override
    public Page<DuAn> searchByNameAndDate(Pageable pageable, String name, String startDate, String endDate) {
        if (name != null && startDate != null && endDate != null) {
            return iDuAnRepository.findByNameContainingAndDateBetween(pageable, name, startDate, endDate);
        } else if (name != null) {
            return iDuAnRepository.searchStudent(pageable, name);
        } else if (startDate != null && endDate != null) {
            return iDuAnRepository.findByDateBetween(pageable, startDate, endDate);
        } else {
            return iDuAnRepository.findAll(pageable);
        }

    }
}
