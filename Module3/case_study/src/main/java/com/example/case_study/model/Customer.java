package com.example.case_study.model;


import java.sql.Date;
import java.time.LocalDate;

public class   Customer {
    private int ma_khach_hang;
    private String ho_ten;
    private Date ngay_sinh;
    private int gioi_tinh;
    private String so_cmnd;
    private String so_dien_thoai;
    private String email;
    private String dia_chi;
    private int ma_loai_khach;
    public Customer() {
    }

    public Customer(String ho_ten, Date ngay_sinh, int gioi_tinh, String so_cmnd, String so_dien_thoai, String email, String dia_chi, int ma_loai_khach) {
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.so_cmnd = so_cmnd;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
        this.dia_chi = dia_chi;
        this.ma_loai_khach = ma_loai_khach;
    }

    public Customer(int ma_khach_hang, String ho_ten, Date ngay_sinh, int gioi_tinh, String so_cmnd, String so_dien_thoai, String email, String dia_chi, int ma_loai_khach) {
        this.ma_khach_hang = ma_khach_hang;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.so_cmnd = so_cmnd;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
        this.dia_chi = dia_chi;
        this.ma_loai_khach = ma_loai_khach;
    }

    public int getId() {
        return ma_khach_hang;
    }

    public void setId(int ma_khach_hang) {
        this.ma_loai_khach = ma_khach_hang;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public int getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(int gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getSo_cmnd() {
        return so_cmnd;
    }

    public void setSo_cmnd(String so_cmnd) {
        this.so_cmnd = so_cmnd;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public int getMa_loai_khach() {
        return ma_loai_khach;
    }

    public void setMa_loai_khach(int ma_loai_khach) {
        this.ma_loai_khach = ma_loai_khach;
    }
}
