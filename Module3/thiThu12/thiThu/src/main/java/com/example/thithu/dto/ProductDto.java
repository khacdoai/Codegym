package com.example.thithu.dto;

public class ProductDto {
    private int id;
    private String maMatHang;
    private String tenMaHang;
    private float gia;
    private int soLuong;
    private  int idLoaiMatHang;
    private  int idNhaSanXuat;
    private String tenLoaiMatHang;
    private String tenNhaSanXuat;

    public ProductDto() {
    }

    public ProductDto(int id, String maMatHang, String tenMaHang, float gia, int soLuong, int idLoaiMatHang, int idNhaSanXuat, String tenLoaiMatHang, String tenNhaSanXuat) {
        this.id = id;
        this.maMatHang = maMatHang;
        this.tenMaHang = tenMaHang;
        this.gia = gia;
        this.soLuong = soLuong;
        this.idLoaiMatHang = idLoaiMatHang;
        this.idNhaSanXuat = idNhaSanXuat;
        this.tenLoaiMatHang = tenLoaiMatHang;
        this.tenNhaSanXuat = tenNhaSanXuat;
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

    public String getTenLoaiMatHang() {
        return tenLoaiMatHang;
    }

    public void setTenLoaiMatHang(String tenLoaiMatHang) {
        this.tenLoaiMatHang = tenLoaiMatHang;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }
}
