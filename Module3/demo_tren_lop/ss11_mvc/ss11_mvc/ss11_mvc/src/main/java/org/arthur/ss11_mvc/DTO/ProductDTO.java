package org.arthur.ss11_mvc.DTO;

public class ProductDTO {
    int id;
    String name;
    double price;
    String country;
    String description;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, double price, String country, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.country = country;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
