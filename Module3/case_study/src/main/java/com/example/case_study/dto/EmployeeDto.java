package com.example.case_study.dto;

import java.sql.Date;

public class EmployeeDto {
    private int maNhanVien;
    private String hoTen;
    private Date ngaySinh;
    private String soCmnd;
    private double luong;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private int maViTri;
    private int maTrinhDo;
    private int maBoPhan;
    private String tenViTri;
    private String tenTrinhDo;
    private String tenBoPhan;

    public EmployeeDto() {
    }

    public EmployeeDto(int maNhanVien, String hoTen, Date ngaySinh, String soCmnd, double luong, String soDienThoai, String email, String diaChi, String tenViTri, String tenTrinhDo, String tenBoPhan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCmnd = soCmnd;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.tenViTri = tenViTri;
        this.tenTrinhDo = tenTrinhDo;
        this.tenBoPhan = tenBoPhan;
    }

    public EmployeeDto(int maNhanVien, String hoTen, Date ngaySinh, String soCmnd, double luong, String soDienThoai, String email, String diaChi, int maViTri, int maTrinhDo, int maBoPhan, String tenViTri, String tenTrinhDo, String tenBoPhan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCmnd = soCmnd;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.maViTri = maViTri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
        this.tenViTri = tenViTri;
        this.tenTrinhDo = tenTrinhDo;
        this.tenBoPhan = tenBoPhan;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public int getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
}
