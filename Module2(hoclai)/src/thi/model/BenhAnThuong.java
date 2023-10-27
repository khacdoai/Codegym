package thi.model;

public class BenhAnThuong extends BenhAn{
    private String sotien;

    public BenhAnThuong() {
    }

    public BenhAnThuong(String sotien) {
        this.sotien = sotien;
    }

    public BenhAnThuong(int stt, String maBehAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyLoBenh, String sotien) {
        super(stt, maBehAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyLoBenh);
        this.sotien = sotien;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }


    public String GetToCSV(){
        return  getStt() + "," + getMaBehAn() + "," + getMaBenhNhan() + "," + getTenBenhNhan() + "," + getNgayNhapVien()+ "," +getNgayRaVien()+","+getLyLoBenh()  + "," + sotien ;
    }

    @Override
    public String toString() {
        return "BenhAnThuong{" +
                "stt=" + getStt() +
                ", maBehAn='" + getMaBehAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + getNgayRaVien() + '\'' +
                ", lyLoBenh='" + getLyLoBenh() + '\'' +
                "sotien='" + sotien + '\'' +
                '}';
    }
}
