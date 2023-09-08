package BaiTapLamThem.QuanLyCanBo.model;

public class officer {
    public String hoten ;
    public int namsinh;
    public String gioitinh;
    public String diachi;

    public officer() {
    }

    public officer(String hoten, int namsinh, String gioitinh, String diachi) {
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "officer{" +
                "hoten='" + hoten + '\'' +
                ", namsinh=" + namsinh +
                ", gioitinh='" + gioitinh + '\'' +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}
