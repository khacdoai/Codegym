package com.example.module3_accountname_wbe.model;

public class Customer {
    private int id;
    private String hoTen;
    private String ngaySinh;
    private boolean gioiTinh;
    private String soCMND;
    private String SDT;
    private String email;
    private String diaChi;
    private String loaiKhach;

    public Customer() {
    }

    public Customer(int id, String hoTen, String ngaySinh, boolean gioiTinh, String soCMND, String SDT, String email, String diaChi, String loaiKhach) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.SDT = SDT;
        this.email = email;
        this.diaChi = diaChi;
        this.loaiKhach = loaiKhach;
    }

    public Customer(String hoTen, String ngaySinh, boolean gioiTinh, String soCMND, String SDT, String email, String diaChi, String loaiKhach) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.SDT = SDT;
        this.email = email;
        this.diaChi = diaChi;
        this.loaiKhach = loaiKhach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
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

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }
}
