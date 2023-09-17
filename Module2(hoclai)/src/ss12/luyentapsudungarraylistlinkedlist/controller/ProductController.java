package ss12.luyentapsudungarraylistlinkedlist.controller;

import ss12.luyentapsudungarraylistlinkedlist.service.IProductService;
import ss12.luyentapsudungarraylistlinkedlist.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    public static void displayMenu(){
        IProductService productService = new ProductService();

        Scanner scanner = new Scanner(System.in);
        boolean chay = true;



        do {
            System.out.println("Chọn chức năng : ");
            System.out.println("1. Hiện thị danh sách. "+
                    "\n 2.Thêm sản phẩm. " +
                    "\n 3.Sửa thông tin sản phẩm theo ID." +
                    "\n 4.Xóa sản phẩm theo ID." +
                    "\n 5.Tìm kiếm sản phẩm theo tên." +
                    "\n 6.Sắp xếp sản phẩm tăng dần/giảm dần theo giá."+
                    "\n 7.Thoát");
            int chon = Integer.parseInt(scanner.nextLine());

            switch (chon){
                case 1:
                    System.out.println("Hiển thị danh sách: ");
                    productService.hienthisanpham();
                    break;
                case 2:
                    System.out.println("Thêm sản phẩm: ");
                    productService.themsanpham();
                    break;
                case 3:
                    System.out.println("Sửa thông tin sản phẩm theo ID:");
                    productService.suathongtinsanphamtheoid();
                    break;
                case 4:
                    System.out.println("Xóa sản phẩm theo ID:");
                    productService.xoasanphamtheoid();
                    break;
                case 5:
                    System.out.println("Tìm kiếm sản phẩm theo tên:");
                    productService.timkiemsanphamtheoten();
                    break;
                case 6:
                    System.out.println("Sắp xếp sản phẩm tăng dần/giảm dần theo giá/theo tên");
                    System.out.println("1.sắp xếp theo tên");
                    System.out.println("2.sắp xếp theo giá tăng dần");
                    System.out.println("3.sắp xếp theo giá giảm dần");
                    int sapxep = Integer.parseInt(scanner.nextLine());
                    productService.sapxepsanpham(sapxep);

                    break;
                case 7:
                    chay = false;

        }
        }while (chay);

    }
}
