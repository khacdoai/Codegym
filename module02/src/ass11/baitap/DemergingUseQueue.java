package ass11.baitap;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {
    String name;
    String gender;
    String dob;

    public Employee(String name, String gender, String dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
}
public class DemergingUseQueue {
    public static void demerge(List<Employee> records) {
        // Tạo 2 queue rỗng
        Queue<Employee> femaleQueue = new LinkedList<>();
        Queue<Employee> maleQueue = new LinkedList<>();

        // Phân loại dữ liệu theo giới tính và đưa vào queue tương ứng
        for (Employee record : records) {
            if (record.gender.equalsIgnoreCase("Female")) {
                femaleQueue.add(record);
            } else if (record.gender.equalsIgnoreCase("Male")) {
                maleQueue.add(record);
            }
        }

        // Xuất dữ liệu từ queue nữ ra file hoặc làm các xử lý khác
        while (!femaleQueue.isEmpty()) {
            Employee employee = femaleQueue.poll();
            // Ghi vào file output cho nữ
            System.out.println("Female: " + employee.name);
        }

        // Xuất dữ liệu từ queue nam ra file hoặc làm các xử lý khác
        while (!maleQueue.isEmpty()) {
            Employee employee = maleQueue.poll();
            // Ghi tiếp vào file output cho nam
            System.out.println("Male: " + employee.name);
        }
    }

    public static void main(String[] args) {
        List<Employee> records = new ArrayList<>();
        records.add(new Employee("Nguyen Van A", "Male", "01/01/1980"));
        records.add(new Employee("Tran Thi B", "Female", "02/03/1990"));
        records.add(new Employee("Pham Van C", "Male", "15/05/1985"));
        records.add(new Employee("Le Thi D", "Female", "10/07/1995"));
        records.add(new Employee("Hoang Van E", "Male", "30/09/1982"));

        demerge(records);
    }
}
