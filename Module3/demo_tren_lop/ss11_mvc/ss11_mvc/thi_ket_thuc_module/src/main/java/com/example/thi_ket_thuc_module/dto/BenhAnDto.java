package com.example.thi_ket_thuc_module.dto;

import java.sql.Date;

public class BenhAnDto {
    private int idBenhAn;
    private int idBenhNhan;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private Date ngayNhapvien;
    private Date ngayRaVien;
    private String lyDoNhapVien;

    public BenhAnDto() {
    }

    public BenhAnDto(int idBenhAn, int idBenhNhan, String maBenhAn, String maBenhNhan, String tenBenhNhan, Date ngayNhapvien, Date ngayRaVien, String lyDoNhapVien) {
        this.idBenhAn = idBenhAn;
        this.idBenhNhan = idBenhNhan;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapvien = ngayNhapvien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public int getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(int idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public int getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(int idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public Date getNgayNhapvien() {
        return ngayNhapvien;
    }

    public void setNgayNhapvien(Date ngayNhapvien) {
        this.ngayNhapvien = ngayNhapvien;
    }

    public Date getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(Date ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

}
