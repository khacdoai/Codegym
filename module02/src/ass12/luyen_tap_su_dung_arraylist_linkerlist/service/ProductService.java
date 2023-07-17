package ass12.luyen_tap_su_dung_arraylist_linkerlist.service;

import ass12.luyen_tap_su_dung_arraylist_linkerlist.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProduct {
    private List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void addNewProduct(){
        System.out.println("Hãy nhập mã của sản phẩm");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Hãy nhập giá của sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id ,name ,price);
        products.add(product);
    }

    public void fixProduct() {
        System.out.println("Vui lòng nhập id của sản phẩm muốn chỉnh sửa");
        int checkId = scanner.nextInt();
        for (Product product : products) {
            if (product.getId() == checkId) {
                System.out.println("Hãy sửa lại tên sản phẩm");
                String name1 = scanner.nextLine() + "\n";
                String name = scanner.nextLine();
                product.setName(name);
                System.out.println("Hãy sửa lại giá của sản phẩm");
                double price = Double.parseDouble(scanner.nextLine());
                product.setCost(price);
                System.out.println("Sản phẩm đã được sửa lại :");
                System.out.println(product);
                break;
            } else {
                System.out.println("Mã sản phẩm không tồn tại đễ xóa");
            }
        }
    }

    public void deleteProduct(){
        System.out.println("Vui lòng nhập id của sản phẩm muốn xóa");
        int checkId = scanner.nextInt();
        for(Product product : products){
            if(product.toString() == checkId){
                products.remove(product);
                System.out.println("Sản phẩm đã được xóa");
                break;
            } else {
                System.out.println("Sản phẩm không tồn tại để xóa");
            }
        }
    }

    public void displayAllProduct() {
        for(Product product : products){
            System.out.println(product.toString());
        }
    }

    public void searchProduct(){
        System.out.println("Vui lòng nhập tên của sản phẩm muốn tìm kiếm");
        String nameOfProduct = scanner.nextLine();
        for(Product product : products){
            if(product.getName().equals(nameOfProduct)){
                System.out.println(product);
            }
        }
    }
}
