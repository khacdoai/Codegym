package com.example.thi_ket_thuc_module3.repository;

import com.example.thi_ket_thuc_module3.Dto.TheMuonSachDto;

import java.util.List;

public interface ITheMuonSachDtoRepository {
    List<TheMuonSachDto> showList();
    TheMuonSachDto layThongTinSach(String id);
    List<TheMuonSachDto> search(String name);


}
