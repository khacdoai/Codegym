package com.example.thithu.model;

public class LoaiMatHang {
    private int idLoaiMatHang;
    private String tenLoaiMatHang;

    public LoaiMatHang() {
    }

    public LoaiMatHang(int idLoaiMatHang, String tenLoaiMatHang) {
        this.idLoaiMatHang = idLoaiMatHang;
        this.tenLoaiMatHang = tenLoaiMatHang;
    }

    public int getIdLoaiMatHang() {
        return idLoaiMatHang;
    }

    public void setIdLoaiMatHang(int idLoaiMatHang) {
        this.idLoaiMatHang = idLoaiMatHang;
    }

    public String getTenLoaiMatHang() {
        return tenLoaiMatHang;
    }

    public void setTenLoaiMatHang(String tenLoaiMatHang) {
        this.tenLoaiMatHang = tenLoaiMatHang;
    }
}
