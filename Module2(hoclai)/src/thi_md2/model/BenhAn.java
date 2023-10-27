package model;

import java.util.Date;

public class BenhAn {
    private int sothutu;
    private int mabenhan;
    private String tenbenhnhan;
    private String ngaynhapvien;
    private String ngayravien;
    private String lydobenh;

    public BenhAn() {
    }

    public BenhAn(int sothutu, int mabenhan, String tenbenhnhan, String ngaynhapvien, String ngayravien, String lydobenh) {
        this.sothutu = sothutu;
        this.mabenhan = mabenhan;
        this.tenbenhnhan = tenbenhnhan;
        this.ngaynhapvien = ngaynhapvien;
        this.ngayravien = ngayravien;
        this.lydobenh = lydobenh;
    }

    public int getSothutu() {
        return sothutu;
    }

    public void setSothutu(int sothutu) {
        this.sothutu = sothutu;
    }

    public int getMabenhan() {
        return mabenhan;
    }

    public void setMabenhan(int mabenhan) {
        this.mabenhan = mabenhan;
    }

    public String getTenbenhnhan() {
        return tenbenhnhan;
    }

    public void setTenbenhnhan(String tenbenhnhan) {
        this.tenbenhnhan = tenbenhnhan;
    }

    public String getNgaynhapvien() {
        return ngaynhapvien;
    }

    public void setNgaynhapvien(String ngaynhapvien) {
        this.ngaynhapvien = ngaynhapvien;
    }

    public String getNgayravien() {
        return ngayravien;
    }

    public void setNgayravien(String ngayravien) {
        this.ngayravien = ngayravien;
    }

    public String getLydobenh() {
        return lydobenh;
    }

    public void setLydobenh(String lydobenh) {
        this.lydobenh = lydobenh;
    }

    @Override
    public String toString() {
        return "BenhAn{" +
                "sothutu=" + sothutu +
                ", mabenhan=" + mabenhan +
                ", tenbenhnhan='" + tenbenhnhan + '\'' +
                ", ngaynhapvien='" + ngaynhapvien + '\'' +
                ", ngayravien='" + ngayravien + '\'' +
                ", lydobenh='" + lydobenh + '\'' +
                '}';
    }
}
