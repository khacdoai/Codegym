package case_study.repository.impl;
import case_study.model.Customer;
import case_study.repository.ICustomerRepository;
import case_study.util.ReadAndWrite;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String Path_Customer = "D:\\CODEGYM\\Module2(hoclai)\\src\\case_study\\data\\customer.csv";

    @Override
    public List<Customer> getListCustomer() {
        List<Customer> customerList = new ArrayList<>();
        // đọc  file ở đây hoặc kết nối DB
        List<String> stringList = ReadAndWrite.readCSVFile(Path_Customer);
        // chuyển thành list customer
        String[] array = null;
        for (String string : stringList) {
            array = string.split(",");
            Customer customer = new Customer(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]), array[5], array[6], array[7]);
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.getInfoToCSV());
        ReadAndWrite.writeToCSV(Path_Customer,stringList,true);
    }

    @Override
    public void deleteCustomerById(int id) {
        List<Customer> customerList = getListCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getMakhachhang() == id){
                customerList.remove(i);
                break;
            }

        }
        List<String> stringList = new ArrayList<>();
        for (Customer customer: customerList) {
            stringList.add(customer.getInfoToCSV());
        }
        ReadAndWrite.writeToCSV(Path_Customer,stringList,false);

    }

    @Override
    public void updateCustomerById(int browseid, Customer newCustomer) {
        boolean check = false;
        List<Customer> customerList = getListCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getMakhachhang() == browseid){
                customerList.get(i).setHoten(newCustomer.getHoten());
                customerList.get(i).setGioitinh(newCustomer.getGioitinh());
                customerList.get(i).setCmnd((int) newCustomer.getCmnd());
                customerList.get(i).setSdt(newCustomer.getSdt());
                customerList.get(i).setEmail(newCustomer.getEmail());
                customerList.get(i).setLoai_khach(newCustomer.getLoai_khach());
                customerList.get(i).setDia_chi(newCustomer.getDia_chi());
                check = true;
                break;
            }
        }
        if(check){
            List<String> stringList = new ArrayList<>();
            for (Customer customer : customerList){
                stringList.add(customer.getInfoToCSV());
            }
            ReadAndWrite.writeToCSV(Path_Customer,stringList,false);
        }
        else {
            System.out.println("Khong tim thay id");
        }

    }


    @Override
    public List<Customer> searchCustomerByName(String name) {
   List<Customer> customerList = getListCustomer();
   List<Customer> searchlist = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getHoten().contains(name)){
                searchlist.add(customerList.get(i));
            }

        }
        return searchlist;
    }

    @Override
    public boolean searchCustomerById(int id) {
        return false;
    }

    @Override
    public Customer findByID(int id) {
        List<Customer> customerList = getListCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getMakhachhang() == id ){
                return customerList.get(i);
            }
        }
        return null;
    }
}
