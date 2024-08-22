package com.example.thi_ket_thuc_module3.service;

import com.example.thi_ket_thuc_module3.model.TheMuonSach;
import com.example.thi_ket_thuc_module3.repository.ITheMuonSachRepository;
import com.example.thi_ket_thuc_module3.repository.TheMuonSachRepository;

import java.util.List;

public class TheMuonSachService implements ITheMuonSachService{
    private ITheMuonSachRepository theMuonSachRepository = new TheMuonSachRepository();
    @Override
    public List<TheMuonSach> showList() {
        return theMuonSachRepository.showList();
    }
}
