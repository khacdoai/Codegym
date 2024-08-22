package com.example.thi_ket_thuc_module.repository;

import com.example.thi_ket_thuc_module.dto.BenhAnDto;
import com.example.thi_ket_thuc_module.model.BenhAn;

import java.util.List;

public interface IBenhAnRepository {
    List<BenhAnDto> showList();
    boolean chinhSuaBenhAn(BenhAnDto benhAnDto);
    boolean xoaBenhAn(int id );
    BenhAnDto layBenhAn(int id);
}
