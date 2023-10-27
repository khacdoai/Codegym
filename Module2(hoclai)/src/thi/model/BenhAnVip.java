package thi.model;

public class BenhAnVip extends BenhAn{
    private String loaiVip;

    public BenhAnVip() {
    }

    public BenhAnVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public BenhAnVip(int stt, String maBehAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyLoBenh, String loaiVip) {
        super(stt, maBehAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyLoBenh);
        this.loaiVip = loaiVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    @Override
    public String toString() {
        return "BenhAnVip{" +
                "stt=" + getStt() +
                ", maBehAn='" + getMaBehAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", ngayRaVien='" + getNgayRaVien() + '\'' +
                ", lyLoBenh='" + getLyLoBenh() + '\'' +
                "loaiVip='" + loaiVip + '\'' +
                '}';
    }
    public String GetToCSV(){
        return getStt() + "," + getMaBehAn() + "," + getMaBenhNhan() + "," + getTenBenhNhan() + "," + getNgayNhapVien()+ "," +getNgayRaVien()+","+getLyLoBenh()  + "," + loaiVip;
    }
}
