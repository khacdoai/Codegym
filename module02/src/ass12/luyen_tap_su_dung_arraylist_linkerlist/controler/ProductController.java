package ass12.luyen_tap_su_dung_arraylist_linkerlist.controler;

import ss12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist.service.ProductService;

import java.util.Scanner;

public class ProductController {
    public static void main(String[] args) {
        IProduct iProduct = new IProduct();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa đổi sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển tất cả sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Sắp xếp các sản phẩm theo giá (Thấp - Cao) ");
            System.out.println("7. Sắp xếp các sản phẩm theo tên A-Z");
            System.out.println("8. Thoát ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iProduct.addNewProduct();
                    break;
                case 2:
                    iProduct.fixProduct();
                    break;
                case 3:
                    iProduct.deleteProduct();
                    break;
                case 4:
                    iProduct.displayAllProduct();
                    break;
                case 5:
                    iProduct.searchProduct();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }while (true) ;

    }
}
