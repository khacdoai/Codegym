package ss8_mvc.bai_tap.service.impl;

import ss8_mvc.bai_tap.model.Customer;
import ss8_mvc.bai_tap.repository.ICustomerRepository;
import ss8_mvc.bai_tap.repository.impl.CustomerRepository;
import ss8_mvc.bai_tap.service.ICustomerService;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void display() {
        ArrayList customerArrayList = customerRepository.getListCustomer();
        for (int i=0; i<customerArrayList.size();i++) {
            if (customerArrayList.get(i) != null) {
                System.out.println((i +1 ) + "." +customerArrayList.get(i));
            }
        }



    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("nhập giá: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("ghi chú: ");
        String note = scanner.nextLine();
        Customer customer = new Customer(id,name,price,note);
        customerRepository.addCustomer(customer);


    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập ID customer cần xóa:  ");
        int id = Integer.parseInt(scanner.nextLine());
        customerRepository.deleteCustomerById(id);

    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập id cần sửa ");
        int searchId = Integer.parseInt(scanner.nextLine());
        if (customerRepository.searchCustomerById(searchId) == true) {
            System.out.print("nhập id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("nhập tên: ");
            String name = scanner.nextLine();
            System.out.print("nhập giá: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.print("ghi chú: ");
            String note = scanner.nextLine();
            Customer customer = new Customer(id, name, price, note);
            customerRepository.updateCustomerById(searchId, customer);
        }if(customerRepository.searchCustomerById(searchId) == false) {
            System.out.println("Không tìm thấy id cần sửa");
        }

    }

    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên muốn tìm :");
        String name = scanner.nextLine();
        customerRepository.searchCustomerByName(name);

    }
}
