package com.example.thithu.model;

public class NhaSanXuat {
    private int idNhaSanXuat;
    private String tenNhaSanXuat;

    public NhaSanXuat() {
    }

    public NhaSanXuat(int idNhaSanXuat, String tenNhaSanXuat) {
        this.idNhaSanXuat = idNhaSanXuat;
        this.tenNhaSanXuat = tenNhaSanXuat;
    }

    public int getIdNhaSanXuat() {
        return idNhaSanXuat;
    }

    public void setIdNhaSanXuat(int idNhaSanXuat) {
        this.idNhaSanXuat = idNhaSanXuat;
    }

    public String getTenNhaSanXuat() {
        return tenNhaSanXuat;
    }

    public void setTenNhaSanXuat(String tenNhaSanXuat) {
        this.tenNhaSanXuat = tenNhaSanXuat;
    }
}
