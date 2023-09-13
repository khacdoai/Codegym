package ss12.luyentapsudungarraylistlinkedlist.repository;

import ss12.luyentapsudungarraylistlinkedlist.model.Product;

import java.util.ArrayList;

public interface IProductRepository {
    ArrayList<Product> getlistProduct();
    void themsanpham(Product product);
    void suathongtinsanphamtheoid(int id, Product product);
    void xoasanphamtheoid(int id);
    void timkiemsanphamtheoten(String name);
    void sapxepsanpham(boolean tanghoacgiam);

}
