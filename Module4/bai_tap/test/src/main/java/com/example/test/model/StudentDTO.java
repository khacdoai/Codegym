package com.example.test.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentDTO implements Validator {
    private Integer id;

    @NotBlank(message = "Vui lòng nhập tên học sinh")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "vui lập nhập đúng định dạng tên")
    @Size(min = 5, message = "Tên tối thiểu 5 ký tự")
    private String ten;
    @NotBlank(message = "Vui lòng chọn ngày sinh")
    private String ngaySinh;

    @NotNull(message = "Vui lòng chọn giới tính")
    private String gioiTinh;
    @NotBlank(message = "vui lòng nhập địa chỉ của học sinh")
    private String diaChi;
    @NotNull(message = "Vui lòng chọn lớp")
    private ClassStudent classStudent;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String ten, String ngaySinh, String gioiTinh, String diaChi, ClassStudent classStudent) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.classStudent = classStudent;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ClassStudent getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(ClassStudent classStudent) {
        this.classStudent = classStudent;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO productDto = (StudentDTO) target;
        String ngaySinh = productDto.getNgaySinh();

        if (ngaySinh == null) {
            errors.rejectValue("ngaySinh", "required", "Vui lòng nhập ngày sinh");
            return;
        }


        }


}
