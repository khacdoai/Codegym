package com.example.thi.modell;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maDuAn;
    private String tenDuAn;
    private double kinhPhi;
    private String moTa;
    private String thoiGianDangKi;
    private String ngayDangKi;
    @ManyToOne
    @JoinColumn(name = "id_doanh_nghiep")
    private DoanhNghiep doanhNghiep;

    public DuAn() {
    }

    public DuAn(Integer id, String maDuAn, String tenDuAn, double kinhPhi, String moTa, String thoiGianDangKi, String ngayDangKi, DoanhNghiep doanhNghiep) {
        this.id = id;
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.kinhPhi = kinhPhi;
        this.moTa = moTa;
        this.thoiGianDangKi = thoiGianDangKi;
        this.ngayDangKi = ngayDangKi;
        this.doanhNghiep = doanhNghiep;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public double getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getThoiGianDangKi() {
        return thoiGianDangKi;
    }

    public void setThoiGianDangKi(String thoiGianDangKi) {
        this.thoiGianDangKi = thoiGianDangKi;
    }

    public String getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(String ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }

    public double tinhChiPhi(){
        if(kinhPhi <= 30000000){
            return kinhPhi * 0.05;
        }else if (kinhPhi <=35000000){
            return kinhPhi * 0.03;
        }else if (kinhPhi >=40000000){
            return kinhPhi * 0.02;
        }else {
            return 0;
        }
    }
}
