package com.example.case_study.model;

public class LoaiKhach {
    private int ma_loai_khach;
    private String ten_loai_khach;

    public LoaiKhach() {
    }

    public LoaiKhach(int ma_loai_khach, String ten_loai_khach) {
        this.ma_loai_khach = ma_loai_khach;
        this.ten_loai_khach = ten_loai_khach;
    }

    public int getMa_loai_khach() {
        return ma_loai_khach;
    }

    public void setMa_loai_khach(int ma_loai_khach) {
        this.ma_loai_khach = ma_loai_khach;
    }

    public String getTen_loai_khach() {
        return ten_loai_khach;
    }

    public void setTen_loai_khach(String ten_loai_khach) {
        this.ten_loai_khach = ten_loai_khach;
    }
}
