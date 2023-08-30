package Kiem_tra.model;

public class Student extends Person {

    private String malophoc;


    public Student() {
    }

    public Student(String malophoc) {
        this.malophoc = malophoc;
    }

    public Student(int code, String name, String dateOfBirth, String gioitinh, String phone, String malophoc) {
        super(code, name, dateOfBirth, gioitinh , phone );
        this.malophoc = malophoc;
    }

    public String toString() {
        return "Mã: "+ super.getCode()+", Tên: "+super.getName();
    }

}
