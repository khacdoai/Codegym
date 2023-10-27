package thi.model;

public  abstract class BenhAn {
    private int stt = 1;
    private String maBehAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyLoBenh;

    public BenhAn() {
    }

    public BenhAn(int stt, String maBehAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyLoBenh) {
        this.stt = stt;
        this.maBehAn = maBehAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyLoBenh = lyLoBenh;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaBehAn() {
        return maBehAn;
    }

    public void setMaBehAn(String maBehAn) {
        this.maBehAn = maBehAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyLoBenh() {
        return lyLoBenh;
    }

    public void setLyLoBenh(String lyLoBenh) {
        this.lyLoBenh = lyLoBenh;
    }

    @Override
    public String toString() {
        return "BenhAn{" +
                "stt=" + stt +
                ", maBehAn='" + maBehAn + '\'' +
                ", maBenhNhan='" + maBenhNhan + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", ngayRaVien='" + ngayRaVien + '\'' +
                ", lyLoBenh='" + lyLoBenh + '\'' +
                '}';
    }
    public String GetToCSV(){
        return getStt() + "," + getMaBehAn() + "," + getMaBenhNhan() + "," + getTenBenhNhan() + "," + getNgayNhapVien()+ "," +getNgayRaVien()+","+getLyLoBenh() ;
    }
}


