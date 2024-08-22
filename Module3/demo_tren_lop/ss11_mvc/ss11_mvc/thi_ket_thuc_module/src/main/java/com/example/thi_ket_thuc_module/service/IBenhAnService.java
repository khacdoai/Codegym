package com.example.thi_ket_thuc_module.service;

import com.example.thi_ket_thuc_module.dto.BenhAnDto;
import com.example.thi_ket_thuc_module.model.BenhAn;

import java.util.List;

public interface IBenhAnService {
    List<BenhAnDto> showList();
    boolean chinhSuaBenhAn(BenhAnDto benhAnDto);
    boolean xoaBenhAn( int id);
    BenhAnDto layBenhAn(int id);
}
