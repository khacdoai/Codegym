package com.example.demo2.Model;

public class Student {
    private int ma_hs;
    private String ten_hs;
    private String ngay_sinh;
    private String email;
    private String lop;
    private String dia_chi;

    public Student() {
    }

    public Student(String ten_hs, String ngay_sinh, String email, String lop, String dia_chi) {
        this.ten_hs = ten_hs;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
        this.lop = lop;
        this.dia_chi = dia_chi;
    }

    public Student(int ma_hs, String ten_hs, String ngay_sinh, String email, String lop, String dia_chi) {
        this.ma_hs = ma_hs;
        this.ten_hs = ten_hs;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
        this.lop = lop;
        this.dia_chi = dia_chi;
    }

    public int getMa_hs() {
        return ma_hs;
    }

    public void setMa_hs(int ma_hs) {
        this.ma_hs = ma_hs;
    }

    public String getTen_hs() {
        return ten_hs;
    }

    public void setTen_hs(String ten_hs) {
        this.ten_hs = ten_hs;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
