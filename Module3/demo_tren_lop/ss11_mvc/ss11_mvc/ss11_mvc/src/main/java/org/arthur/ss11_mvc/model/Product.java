package org.arthur.ss11_mvc.model;

public class Product {
    int id;
    String name;
    double price;
    String description;
    int idCountry;

    public Product() {
    }

    public Product(int id, String name, double price, String description, int idCountry) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.idCountry = idCountry;
    }
    public Product( String name, double price, String description, int  idCountry) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.idCountry = idCountry;
    }

    public int getId() {
        return id;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int id_country) {
        this.idCountry = id_country;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
