package com.example.sping_boot.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDTO implements Validator {
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tên học viên")
    @Pattern(regexp = "^[A-Za-z ]*$",message = "Vui lòng nhập đúng định dạng tên")
    @Size(min = 6, message = "Tên tối thiểu phải chứa 6 ký tự")
    @Size(max = 9, message = "Tên tối đa phải chứa 9 ký tự")
    private String name;

    private String email;
    private CodeGymClass codeGymClass;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, String email, CodeGymClass codeGymClass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.codeGymClass = codeGymClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CodeGymClass getCodeGymClass() {
        return codeGymClass;
    }

    public void setCodeGymClass(CodeGymClass codeGymClass) {
        this.codeGymClass = codeGymClass;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO student = (StudentDTO) target;
        if("".equals(student.getEmail())){
            errors.rejectValue("email","","Vui lòng nhập email");
        }
    }
}
