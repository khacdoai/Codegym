package ss12.luyentapsudungarraylistlinkedlist.repository.impl;

import ss12.luyentapsudungarraylistlinkedlist.model.CompaByName;
import ss12.luyentapsudungarraylistlinkedlist.model.Product;
import ss12.luyentapsudungarraylistlinkedlist.model.sap_xep_giam;
import ss12.luyentapsudungarraylistlinkedlist.model.sap_xep_tang;
import ss12.luyentapsudungarraylistlinkedlist.repository.IProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class ProductRepository implements IProductRepository {
    private static ArrayList<Product> productArrayList = new ArrayList<>(20);

    static {
        productArrayList.add(new Product(1, "thia", 200000, "dễ vỡ"));
        productArrayList.add(new Product(2, "noi", 250000, "dễ vỡ"));
        productArrayList.add(new Product(3, "dia", 9900000, "bằng inox"));
        productArrayList.add(new Product(6, "chen", 13000000, "dễ vỡ"));
        productArrayList.add(new Product(7, "dua", 20000, "bằng gỗ"));

    }

    @Override
    public ArrayList<Product> getlistProduct() {
        return productArrayList;
    }

    @Override
    public void themsanpham(Product product) {
          if(kiemtraId(product.getId())==true){
              System.out.println("id bi trung");
          }else {
              productArrayList.add(product);
          }

    }

    @Override
    public void suathongtinsanphamtheoid(int id, Product product) {
        if (kiemtraId(id)) {
            for (int i = 0; i < productArrayList.size(); i++) {
                if (productArrayList.get(i).getId() == id) {
                    productArrayList.remove(i);
                    productArrayList.add(product);
                }
            }
        } else {
            System.out.println("Vui lòng nhập đúng ID");
        }
    }

    @Override
    public void xoasanphamtheoid(int id) {
        if (kiemtraId(id)) {
            for (int i=0;i<productArrayList.size();i++){
                if(productArrayList.get(i).getId() == id){
                    productArrayList.remove(i);
                }
            }
        }else {
            System.out.println("khong tim thay id");
        }

    }

    @Override
    public void timkiemsanphamtheoten(String name) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getTensanpham().equals(name)) {
                System.out.println(productArrayList.get(i).toString());
                break;
            } else {
                System.out.println("Không tìm thấy");
            }
        }

    }

    @Override
    public ArrayList<Product> sapxepsanphamtheoten() {
        Collections.sort(productArrayList, new CompaByName());
        return productArrayList;


    }

    @Override
    public ArrayList<Product> sapxepsanphamtheogiatang() {
        Collections.sort(productArrayList, new sap_xep_tang());
        return productArrayList;
    }

    @Override
    public ArrayList<Product> sapxepsanphamtheogiagiam() {
        Collections.sort(productArrayList, new sap_xep_giam());
        return productArrayList;
    }

    @Override
    public boolean kiemtraId(int id) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

}
