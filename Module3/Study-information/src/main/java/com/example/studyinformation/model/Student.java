package com.example.studyinformation.model;

public class Student {
    private int ma_HS;
    private String ten_HS;
    private String ngay_sinh;
    private String email;
    private String lop;
    private String dia_chi;
    private int trang_thai;

    public Student() {
    }

    public Student(String ten_HS, String ngay_sinh, String email, String lop, String dia_chi) {
        this.ten_HS = ten_HS;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
        this.lop = lop;
        this.dia_chi = dia_chi;
    }

    public Student(String ten_HS, String ngay_sinh, String email, String lop, String dia_chi, int trang_thai) {
        this.ten_HS = ten_HS;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
        this.lop = lop;
        this.dia_chi = dia_chi;
        this.trang_thai = trang_thai;
    }

    public Student(int ma_HS, String ten_HS, String ngay_sinh, String email, String lop, String dia_chi, int trang_thai) {
        this.ma_HS = ma_HS;
        this.ten_HS = ten_HS;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
        this.lop = lop;
        this.dia_chi = dia_chi;
        this.trang_thai = trang_thai;
    }

    public int getMa_HS() {
        return ma_HS;
    }

    public void setMa_HS(int ma_HS) {
        this.ma_HS = ma_HS;
    }

    public String getTen_HS() {
        return ten_HS;
    }

    public void setTen_HS(String ten_HS) {
        this.ten_HS = ten_HS;
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

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }
}
