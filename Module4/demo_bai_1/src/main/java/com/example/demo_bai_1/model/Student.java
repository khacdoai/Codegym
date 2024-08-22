package com.example.demo_bai_1.model;

public class Student {
    private int id;
    private String ten;
    private String email;
    private String diaChi;

    public Student() {
    }

    public Student(int id, String ten, String email, String diaChi) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
}
