package ss12.luyentapsudungarraylistlinkedlist.repository.impl;

import ss12.luyentapsudungarraylistlinkedlist.model.Product;
import ss12.luyentapsudungarraylistlinkedlist.repository.IProductRepository;

import java.util.ArrayList;

public class ProductRepository implements IProductRepository {
     private  static ArrayList<Product> productArrayList = new ArrayList<>(20);
     static {
         productArrayList.add(new Product(1, "chen", 200000,"dễ vỡ"));
         productArrayList.add(new Product(1, "dĩa", 250000,"dễ vỡ"));
         productArrayList.add(new Product(1, "nồi", 9900000,"bằng inox"));
         productArrayList.add(new Product(1, "niêu", 13000000,"dễ vỡ"));
         productArrayList.add(new Product(1, "thìa", 20000,"bằng gỗ"));

     }

    @Override
    public ArrayList<Product> getlistProduct() {
        return productArrayList;
    }

    @Override
    public void themsanpham(Product product) {
         productArrayList.add(product);

    }

    @Override
    public void suathongtinsanphamtheoid(int id, Product product) {

    }

    @Override
    public void xoasanphamtheoid(int id) {

    }

    @Override
    public void timkiemsanphamtheoten(String name) {

    }

    @Override
    public void sapxepsanpham(boolean tanghoacgiam) {

    }
}
