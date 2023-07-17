package ass6.baitap.lop_point_va_moveablepoint;

import java.util.Arrays;

public class TestPoint {
    public static void main(String[] args) {
        Point point1 = new Point();
        System.out.println(point1);
        Point point2 = new Point(2.3f , 5.7f);
        System.out.println(point2);
        System.out.println(point2.getX());
        System.out.println(point2.getY());
        point2.setXY(2f,5f);
        System.out.println(Arrays.toString(point2.getXY()));



    }
}
