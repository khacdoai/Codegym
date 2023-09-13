package ss12.luyentapsudungarraylistlinkedlist.service.impl;

import Ass8_MVC.bai_tap.Customer.repository.ICustomerRepository;
import ss12.luyentapsudungarraylistlinkedlist.model.Product;
import ss12.luyentapsudungarraylistlinkedlist.repository.IProductRepository;
import ss12.luyentapsudungarraylistlinkedlist.repository.impl.ProductRepository;
import ss12.luyentapsudungarraylistlinkedlist.service.IProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService implements IProductService {
    Scanner scanner = new Scanner(System.in);
   private IProductRepository productRepository = new ProductRepository();

    @Override
    public void hienthisanpham() {
        ArrayList productArraylist = productRepository.getlistProduct();
        for (int i =0; i<productArraylist.size();i++) {
            if (productArraylist.get(i) != null) {
                System.out.println((i + 1) + "." + productArraylist.get(i));
            }
        }
    }

    @Override
    public void themsanpham() {
        System.out.println("Nhập ID sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String tensp = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        int gia = Integer.parseInt(scanner.nextLine());
        System.out.println("Thêm ghi chú của sản phẩm: ");
        String ghichu = scanner.nextLine();
        Product product = new Product(id,tensp,gia,ghichu);
        productRepository.themsanpham(product);
    }

    @Override
    public void suathongtinsanphamtheoid() {

    }

    @Override
    public void xoasanphamtheoid() {

    }

    @Override
    public void timkiemsanphamtheoten() {

    }

    @Override
    public void sapxepsanpham() {

    }
}
