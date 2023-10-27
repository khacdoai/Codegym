package model;

public class BenhAnThuong extends BenhAn {
    private double inlibrary;

    public BenhAnThuong() {
    }

    public BenhAnThuong(double inlibrary) {
        this.inlibrary = inlibrary;
    }

    public BenhAnThuong(int sothutu, int mabenhan, String tenbenhnhan, String ngaynhapvien, String ngayravien, String lydobenh, double inlibrary) {
        super(sothutu, mabenhan, tenbenhnhan, ngaynhapvien, ngayravien, lydobenh);
        this.inlibrary = inlibrary;
    }

    public double getInlibrary() {
        return inlibrary;
    }

    public void setInlibrary(double inlibrary) {
        this.inlibrary = inlibrary;
    }

    @Override
    public String toString() {
        return "BenhAnThuong{" + super.toString() +
                "inlibrary=" + inlibrary +
                '}';
    }
}
