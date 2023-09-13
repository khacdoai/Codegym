package ss12.luyentapsudungarraylistlinkedlist.model;

public class Product {
    private int id;
    private String tensanpham;
    private int gia;
    private String ghichu;

    public Product() {
    }

    public Product(int id, String tensanpham, int gia, String ghichu) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.gia = gia;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", tensanpham='" + tensanpham + '\'' +
                ", gia=" + gia +
                ", ghichu='" + ghichu + '\'' +
                '}';
    }
}
