package com.example.bai_tap_lam_them.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDTO implements Validator {
    private Integer id;

    @NotBlank(message = "Vui lòng nhập tên sản phẩm")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Vui lòng nhập đúng định dạng tên")
    @Size(min = 6, message = "Tên tối thiểu phải chứa 6 ký tự")
    @Size(max = 9, message = "Tên tối đa phải chứa 9 ký tự")
    private String ten;

    @NotNull(message = "Vui lòng nhập giá của sản phẩm")
    @Min(value = 1, message = "vui lông nhập giá lớn hơn 1")
    private Double gia;
    @NotNull(message = "Vui lòng nhập số lượng sản phẩm")
    @Min(value = 1, message = "vui lòng nhập giá lớn hơn 1")
    private Integer soLuong;

    @NotBlank(message = "Vui lòng nhập nhà sản xuất sản phẩm sản phẩm")
    @Size(min = 5, message = "Tên tối thiểu phải chứa 5 ký tự")
    @Size(max = 10, message = "Tên tối đa phải chứa 10 ký tự")
    private String nhaSanXuat;
    @NotNull(message = "vui lòng chọn tên doanh nghiệp")
    private ProductDetail productDetail;


    public ProductDTO() {
    }

    public ProductDTO(Integer id, String ten, Double gia, Integer soLuong, String nhaSanXuat, ProductDetail productDetail) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
        this.productDetail = productDetail;
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

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

                ProductDTO productDto = (ProductDTO) target;
                String nhaSanXuat = productDto.getNhaSanXuat();

            // Định dạng ngày tháng bạn mong đợi
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            dateFormat.setLenient(false); // Tắt tính linh hoạt trong phân tích

            try {
                // Cố gắng phân tích chuỗi ngày tháng
                Date parsedDate = dateFormat.parse(nhaSanXuat);

                // Nếu phân tích thành công, chuỗi là hợp lệ
            } catch (ParseException e) {
                // Nếu phân tích không thành công, chuỗi không hợp lệ
                errors.rejectValue("nhaSanXuat", "invalid.date.format", "Định dạng ngày không hợp lệ");

        }

    }
}
