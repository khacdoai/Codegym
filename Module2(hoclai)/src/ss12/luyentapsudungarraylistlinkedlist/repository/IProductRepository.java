package ss12.luyentapsudungarraylistlinkedlist.repository;

import ss8_mvc.bai_tap.model.Customer;
import ss12.luyentapsudungarraylistlinkedlist.model.Product;

import java.util.ArrayList;

public interface IProductRepository {
    ArrayList<Product> getlistProduct();
    void themsanpham(Product product);
    void suathongtinsanphamtheoid(int id, Product product);
    void xoasanphamtheoid(int id);
    void timkiemsanphamtheoten(String name);
    ArrayList<Product> sapxepsanphamtheoten();
    ArrayList<Product> sapxepsanphamtheogiatang();
    ArrayList<Product> sapxepsanphamtheogiagiam();

    boolean kiemtraId(int id);

}
