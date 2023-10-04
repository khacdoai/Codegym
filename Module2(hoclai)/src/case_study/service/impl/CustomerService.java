package case_study.service.impl;

import case_study.model.Customer;
import case_study.repository.impl.ICustomerRepository;
import case_study.repository.impl.CustomerRepository;
import case_study.service.ICustomerService;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        List<Customer> customerList = customerRepository.getListCustomer();
        for (int i =0; i < customerList.size(); i++){
            if(customerList.get(i) != null){
                System.out.println((i+1) + ". " + customerList.get(i) );
            }
        }
    }

    @Override
    public void add() {
        System.out.printf("Nhap ID khach hang");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.printf("Nhap ten khach hang: ");
        String ten = scanner.nextLine();
        System.out.printf("Nhap gioi tinh:");
        String gioitinh = scanner.nextLine();
        System.out.printf("Nhap CMND khach hang");
        int cmnd = Integer.parseInt(scanner.nextLine());
        System.out.printf("Nhap so dien thoai khach hang");
        int sdt = Integer.parseInt(scanner.nextLine());
        System.out.printf("Nhap email khach hang");
        String email = scanner.nextLine();
        System.out.printf("Nhap loai khach hang");
        String loai = scanner.nextLine();
        System.out.printf("Nhap dia chi khach hang");
        String diachi = scanner.nextLine();
        Customer customer = new Customer(id,ten,gioitinh,cmnd,sdt,email,loai,diachi);
        customerRepository.addCustomer(customer);

    }

    @Override
    public void update() {
        System.out.print("Nhap ID can sua: ");
        int idTest = Integer.parseInt(scanner.nextLine());
        Customer setcustomer = customerRepository.findByID(idTest);
        if(setcustomer != null){
            System.out.printf("Nhap ten khach hang can sua: ");
            String newten = scanner.nextLine();
            System.out.printf("Nhap gioi tinh can sua:");
            String newgioitinh = scanner.nextLine();
            System.out.printf("Nhap CMND khach hang can sua");
            int newcmnd = Integer.parseInt(scanner.nextLine());
            System.out.printf("Nhap so dien thoai khach hang can sua");
            int newsdt = Integer.parseInt(scanner.nextLine());
            System.out.printf("Nhap email khach hang can sua");
            String newemail = scanner.nextLine();
            System.out.printf("Nhap loai khach hang can sua");
            String newloai = scanner.nextLine();
            System.out.printf("Nhap dia chi khach hang can sua");
            String newdiachi = scanner.nextLine();
            setcustomer.setHoten(newten);
            setcustomer.setGioitinh(newgioitinh);
            setcustomer.setCmnd(newcmnd);
            setcustomer.setSdt(newsdt);
            setcustomer.setEmail(newemail);
            setcustomer.setLoai_khach(newloai);
            setcustomer.setDia_chi(newdiachi);
            customerRepository.updateCustomerById(idTest,setcustomer);
        }else {
            System.out.println("Không tìm thấy ID");
        }

    }

    @Override
    public void delete() {
        System.out.printf("Nhap ID can xoa: ");
        int id = Integer.parseInt(scanner.nextLine());
        customerRepository.deleteCustomerById(id);


    }

    @Override
    public void search() {

        System.out.printf("Nhap ten can tim: ");
        String name = scanner.nextLine();
        List<Customer> customerList = customerRepository.searchCustomerByName(name);
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i) != null){
                System.out.println((i+1) + "." + customerList.get(i));
            }
        }
    }
}
