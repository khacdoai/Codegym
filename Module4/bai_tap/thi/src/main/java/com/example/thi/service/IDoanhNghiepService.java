package com.example.thi.service;

import com.example.thi.modell.DoanhNghiep;
import com.example.thi.repository.IDoanhNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDoanhNghiepService {
    List<DoanhNghiep> showList();

}
