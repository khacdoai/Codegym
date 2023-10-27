package model;

public class BenhAnVip extends BenhAn{
    private String viptype;

    public BenhAnVip(String viptype) {
        this.viptype = viptype;
    }

    public BenhAnVip(int sothutu, int mabenhan, String tenbenhnhan, String ngaynhapvien, String ngayravien, String lydobenh, String viptype) {
        super(sothutu, mabenhan, tenbenhnhan, ngaynhapvien, ngayravien, lydobenh);
        this.viptype = viptype;
    }

    public BenhAnVip() {
    }

    public String getViptype() {
        return viptype;
    }

    public void setViptype(String viptype) {
        this.viptype = viptype;
    }

    @Override
    public String toString() {
        return "BenhAnVip{" + super.toString() +
                "viptype='" + viptype + '\'' +
                '}';
    }
}
