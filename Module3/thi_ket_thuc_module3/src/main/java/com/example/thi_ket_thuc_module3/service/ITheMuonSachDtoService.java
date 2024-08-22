package com.example.thi_ket_thuc_module3.service;

import com.example.thi_ket_thuc_module3.Dto.TheMuonSachDto;

import java.util.List;

public interface ITheMuonSachDtoService {
    List<TheMuonSachDto> showList();
    TheMuonSachDto layThongTinSach(String id);
    List<TheMuonSachDto> search(String name);
}
