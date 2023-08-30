package Kiem_tra.model;

public  abstract class Person {
    private int code;
    private String name;
    private String dateOfBirth;
    private String gioitinh;
    private String phone;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGioitinh() {return gioitinh;}

    public void setGioitinh(String gioitinh) {this.gioitinh = gioitinh;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public Person() {
    }

    public Person(int code, String name, String dateOfBirth, String gioitinh, String phone) {
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gioitinh = gioitinh;
        this.phone = phone;

    }
}
