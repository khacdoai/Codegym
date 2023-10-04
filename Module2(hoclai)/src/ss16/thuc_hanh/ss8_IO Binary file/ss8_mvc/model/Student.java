package ss8_mvc.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Student implements Serializable {
    private int id;
    private String name;
    private String className;

    public Student() {
    }

    public Student(int id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

//    @Override
//    public boolean equals(Object o) {
//        Student student = (Student) o;
//        // nếu id bằng nhanh thì xem như bằng nhau
//        return id == student.id && student.getName().equals(((Student) o).getName());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id,getName());
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
    public String getInfoToCSV(){
        return id +","+name+","+className;
    }

    public void study(){
        System.out.println("đang học");
    }

//    @Override
//    public int compareTo(Student o) {
//        if (this.name.compareTo(o.getName())==0){
//            return o.getId()-this.id;
//        }
//      return this.name.compareTo(o.getName());
//    }
}
