package com.example.thi.modell;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.springframework.data.domain.Page;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DuAnDTO implements Validator {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập mã dự án ")
    @Pattern(regexp = "^DA-[0-9]{3}$", message = "Mã dự án phải có định dạng DA-XXX")
    private String maDuAn;
    @NotBlank(message = "Vui lòng nhập tên dự án ")
    @Size(min = 6, message = "tên dự án phải lớn hơn 6 kí tự")
    private String tenDuAn;
    @NotNull(message = "Vui lòng nhập kinh phí")
    @Min(value = 30000000, message = "kinh phí phải lớn hơn 30.000.000")
    private double kinhPhi;
    @NotBlank(message = "Vui lòng nhập mô tả dự án ")
    private String moTa;
    @NotBlank(message = "Vui lòng nhập thời gian đăng kí dự án ")
    @Size(min = 1,max = 12, message = "thời gian đăng kí là tháng không được bé hơn 1 và lớn hơn 12")
    private String thoiGianDangKi;
    @NotBlank(message = "Vui lòng nhập ngày đăng kí dự án ")
    private String ngayDangKi;

    @NotNull(message = "Vui lòng tên doanh nghiệp")
    private DoanhNghiep doanhNghiep;

    public DuAnDTO() {
    }

    public DuAnDTO(Integer id, String maDuAn, String tenDuAn, double kinhPhi, String moTa, String thoiGianDangKi, String ngayDangKi, DoanhNghiep doanhNghiep) {
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



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
