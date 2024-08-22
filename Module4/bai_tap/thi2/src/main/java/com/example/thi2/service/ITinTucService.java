package com.example.thi2.service;

import com.example.thi2.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITinTucService {
    Page<TinTuc> hienThi(Pageable pageable);
    void themMoi(TinTuc tinTuc);
    void Xoa(Long id);
    Page<TinTuc> search(Pageable pageable,String name,Integer danhMuc);
    TinTuc selecter(Long id);
}
