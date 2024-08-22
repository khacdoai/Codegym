package com.example.thi_ket_thuc_module3.model;

public class HocSinh {
    private int maHocSinh;
    private String hoTen;
    private String Lop;

    public HocSinh() {
    }

    public HocSinh(int maHocSinh, String hoTen, String lop) {
        this.maHocSinh = maHocSinh;
        this.hoTen = hoTen;
        Lop = lop;
    }

    public int getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(int maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }
}
