package com.example.thithu.model;

public class Product {
    private int id;
    private String maMatHang;
    private String tenMaHang;
    private float gia;
    private int soLuong;
    private  int idLoaiMatHang;
    private  int idNhaSanXuat;

    public Product() {
    }

    public Product(int id, String maMatHang, String tenMaHang, float gia, int soLuong, int idLoaiMatHang, int idNhaSanXuat) {
        this.id = id;
        this.maMatHang = maMatHang;
        this.tenMaHang = tenMaHang;
        this.gia = gia;
        this.soLuong = soLuong;
        this.idLoaiMatHang = idLoaiMatHang;
        this.idNhaSanXuat = idNhaSanXuat;
    }

    public Product(String maMatHang, String tenMaHang, float gia, int soLuong, int idLoaiMatHang, int idNhaSanXuat) {
        this.maMatHang = maMatHang;
        this.tenMaHang = tenMaHang;
        this.gia = gia;
        this.soLuong = soLuong;
        this.idLoaiMatHang = idLoaiMatHang;
        this.idNhaSanXuat = idNhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(String maMatHang) {
        this.maMatHang = maMatHang;
    }

    public String getTenMaHang() {
        return tenMaHang;
    }

    public void setTenMaHang(String tenMaHang) {
        this.tenMaHang = tenMaHang;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdLoaiMatHang() {
        return idLoaiMatHang;
    }

    public void setIdLoaiMatHang(int idLoaiMatHang) {
        this.idLoaiMatHang = idLoaiMatHang;
    }

    public int getIdNhaSanXuat() {
        return idNhaSanXuat;
    }

    public void setIdNhaSanXuat(int idNhaSanXuat) {
        this.idNhaSanXuat = idNhaSanXuat;
    }
}
