package com.example.thi2.model;

import jakarta.persistence.*;

@Entity
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tieuDe;
    private String noiDung;
    private String ngayDangTin;
    private String phongVien;
    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc danhMuc;

    public TinTuc() {
    }

    public TinTuc(Integer id, String tieuDe, String noiDung, String ngayDangTin, String phongVien, DanhMuc danhMuc) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.danhMuc = danhMuc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(String ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
