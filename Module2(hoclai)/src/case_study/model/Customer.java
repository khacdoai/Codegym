package case_study.model;

public class Customer {
    private int makhachhang ;
    private String hoten;
    private String gioitinh;
    private int cmnd;
    private int sdt;
    private String email;
    private String loai_khach;
    private String dia_chi;

    public Customer() {
    }

    public Customer(int makhachhang, String hoten, String gioitinh, int cmnd, int sdt, String email, String loai_khach, String dia_chi) {
        this.makhachhang = makhachhang;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.email = email;
        this.loai_khach = loai_khach;
        this.dia_chi = dia_chi;
    }

    public int getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(int makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public double getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoai_khach() {
        return loai_khach;
    }

    public void setLoai_khach(String loai_khach) {
        this.loai_khach = loai_khach;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
    public String getInfoToCSV(){return makhachhang +"," + hoten+"," +gioitinh+","+cmnd+","+sdt+","+email+","+loai_khach+","+dia_chi;}

    @Override
    public String toString() {
        return "Customer{" +
                "makhachhang=" + makhachhang +
                ", hoten='" + hoten + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", cmnd=" + cmnd +
                ", sdt=" + sdt +
                ", email='" + email + '\'' +
                ", loai_khach='" + loai_khach + '\'' +
                ", dia_chi='" + dia_chi + '\'' +
                '}';
    }
}
