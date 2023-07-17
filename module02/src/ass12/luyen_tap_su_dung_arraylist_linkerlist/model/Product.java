package ass12.luyen_tap_su_dung_arraylist_linkerlist.model;


public class Product {
    private int id ;
    private String name;
    private double price ;

    public Product(int id , String name , double price){
        this.id = id ;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return price;
    }

    public void setCost(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +  " VND" +
                '}';
    }
}
