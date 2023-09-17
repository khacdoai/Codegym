package ss12.luyentapsudungarraylistlinkedlist.service.impl;

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
        System.out.println("Thêm ghi chú của sản phẩm: ");String ghichu = scanner.nextLine();
        Product product = new Product(id,tensp,gia,ghichu);
        productRepository.themsanpham(product);

    }

    @Override
    public void suathongtinsanphamtheoid() {
        System.out.println("Nhập id cần sửa");
        int ids = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ID sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String tensp = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        int gia = Integer.parseInt(scanner.nextLine());
        System.out.println("Thêm ghi chú của sản phẩm: ");
        String ghichu = scanner.nextLine();
        Product product = new Product(id,tensp,gia,ghichu);
        productRepository.suathongtinsanphamtheoid(ids,product);
    }

    @Override
    public void xoasanphamtheoid() {
        System.out.println("Nhập id cần xóa:");
        int id = Integer.parseInt(scanner.nextLine());
        productRepository.xoasanphamtheoid(id);

    }

    @Override
    public void timkiemsanphamtheoten() {
        String ten = scanner.nextLine();
        productRepository.timkiemsanphamtheoten(ten);

    }

    @Override
    public void sapxepsanpham(int sapxep) {

        switch (sapxep){
            case 1:
                ArrayList<Product> product1 = productRepository.sapxepsanphamtheoten();
                for (int i=0;i <product1.size();i++){
                    if(product1.get(i) != null){
                        System.out.println((i+1) + "." + product1.get(i));
                    }
                }
                break;
            case 2:
                ArrayList<Product> product2 = productRepository.sapxepsanphamtheogiatang();
                for (int i=0;i <product2.size();i++){
                    if(product2.get(i) != null){
                        System.out.println((i+1) + "." + product2.get(i));
                    }
                }
                break;
            case 3:
                ArrayList<Product> product3 = productRepository.sapxepsanphamtheogiagiam();
                for (int i=0;i <product3.size();i++){
                    if(product3.get(i) != null){
                        System.out.println((i+1) + "." + product3.get(i));
                    }
                }
                break;
        }


    }
}
