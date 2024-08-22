package com.example.thi_ket_thuc_module3.service;

import com.example.thi_ket_thuc_module3.Dto.TheMuonSachDto;
import com.example.thi_ket_thuc_module3.repository.ITheMuonSachDtoRepository;
import com.example.thi_ket_thuc_module3.repository.TheMuonSachDtoRepository;

import java.util.List;

public class TheMuonSachDtoService implements ITheMuonSachDtoService{
    private ITheMuonSachDtoRepository theMuonSachDtoRepository = new TheMuonSachDtoRepository();
    @Override
    public List<TheMuonSachDto> showList() {
        return theMuonSachDtoRepository.showList();
    }

    @Override
    public TheMuonSachDto layThongTinSach(String id) {
        return theMuonSachDtoRepository.layThongTinSach(id);
    }

    @Override
    public List<TheMuonSachDto> search(String name) {
        return theMuonSachDtoRepository.search(name);
    }
}
