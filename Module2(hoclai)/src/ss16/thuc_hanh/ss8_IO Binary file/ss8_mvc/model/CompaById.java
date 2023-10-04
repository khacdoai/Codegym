package ss8_mvc.model;

import java.util.Comparator;

public class CompaById implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId()-o2.getId();
    }
}
