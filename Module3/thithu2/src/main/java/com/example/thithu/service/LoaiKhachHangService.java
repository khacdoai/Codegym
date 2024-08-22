package com.example.thithu.service;

import com.example.thithu.model.LoaiMatHang;
import com.example.thithu.repository.ILoaiMatHangRepository;
import com.example.thithu.repository.impl.LoaiMatHangRepository;

import java.util.List;

public class LoaiKhachHangService implements ILoaiKhachhangService{
    private ILoaiMatHangRepository loaiMatHangRepository = new LoaiMatHangRepository();
    @Override
    public List<LoaiMatHang> showlist() {
        return loaiMatHangRepository.showlist();
    }
}
