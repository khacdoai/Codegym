package org.c07.movie_booking.dto.response;

public class UserResDTO {
    private Long id;
    private String code;

    private String name;

    private String cardId;

    private String email;

    private boolean gender;

    private boolean status;

    private String phoneNumber;
    private String avatar;
    private String address;
    private String password;
    private Long role_id;

    public UserResDTO() {
    }

    public UserResDTO(Long id, String code, String name, String cardId, String email, boolean gender, boolean status, String phoneNumber, String avatar, String address, String password, Long role_id) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.cardId = cardId;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.address = address;
        this.password = password;
        this.role_id = role_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
