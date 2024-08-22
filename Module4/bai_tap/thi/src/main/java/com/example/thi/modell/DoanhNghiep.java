package com.example.thi.modell;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DoanhNghiep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenDoanhNghiep;
    private String linhVucKinhDoanh;
    private String sdt;
    private String email;
    private String diaChi;

    public DoanhNghiep() {
    }

    public DoanhNghiep(Integer id, String tenDoanhNghiep, String linhVucKinhDoanh, String sdt, String email, String diaChi) {
        this.id = id;
        this.tenDoanhNghiep = tenDoanhNghiep;
        this.linhVucKinhDoanh = linhVucKinhDoanh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDoanhNghiep() {
        return tenDoanhNghiep;
    }

    public void setTenDoanhNghiep(String tenDoanhNghiep) {
        this.tenDoanhNghiep = tenDoanhNghiep;
    }

    public String getLinhVucKinhDoanh() {
        return linhVucKinhDoanh;
    }

    public void setLinhVucKinhDoanh(String linhVucKinhDoanh) {
        this.linhVucKinhDoanh = linhVucKinhDoanh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
