package ss8_mvc.bai_tap.model;

public class Customer {
    private int id;
    private String name;
    private int price;
    private String note;

    public Customer() {
    }

    public Customer(int id, String name, int price, String note) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }

}
