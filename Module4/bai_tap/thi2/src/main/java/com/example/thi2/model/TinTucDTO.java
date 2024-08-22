package com.example.thi2.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TinTucDTO implements Validator {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tiêu đề")
    @Size(max = 50, message = "tiêu đề không quá 50 kí tự")
    private String tieuDe;
    @NotBlank(message = "vui lòng nhập nội dung")
    @Size(max = 500, message = "tiêu đề không quá 500 kí tự")
    private String noiDung;
    @NotBlank(message = "Vui lòng nhập ngày đăng tin")
    private String ngayDangTin;
    @NotBlank(message = "Vui lòng nhập tên phóng viên")
    private String phongVien;
    @NotNull(message = "Vui lòng chọn danh mục")
    private DanhMuc danhMuc;

    public TinTucDTO() {
    }

    public TinTucDTO(Integer id, String tieuDe, String noiDung, String ngayDangTin, String phongVien, DanhMuc danhMuc) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.danhMuc = danhMuc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(String ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TinTucDTO productDto = (TinTucDTO) target;


    }
}
