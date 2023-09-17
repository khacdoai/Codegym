package ss12.thuchanh.ss12_map.ss12_map;

import ss8_mvc.thuc_hanh.model.Student;

import java.util.*;

public class DemoMap {
    public static void main(String[] args) {
        // tạo một Map
        Map<Student, Integer> studentMap = new TreeMap<>();
        studentMap.put(new Student(1,"chanh11","A05"),1);
        studentMap.put(new Student(3,"chanh3","A05"),3);
        studentMap.put(new Student(2,"chanh2","A05"),2);

        studentMap.put(new Student(1,"chanh1","A05"),10);
        studentMap.put(new Student(3,"chanh3","A05"),30);

       Set<Student> studentSet = studentMap.keySet();
        for (Student s: studentSet) {
            System.out.println("học viên : "+ s + " vắng nghỉ : " + studentMap.get(s) );
        }
        System.out.println("-------------------------------------------");
        Set<Map.Entry<Student,Integer>> entries = studentMap.entrySet();
        for (Map.Entry<Student,Integer> entry: entries) {
            System.out.println("học viên : "+ entry.getKey() + " vắng nghỉ : " + entry.getValue() );
        }
    }
}
