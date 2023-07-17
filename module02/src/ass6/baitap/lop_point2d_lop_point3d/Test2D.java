package ass6.baitap.lop_point2d_lop_point3d;

import ass6.baitap.lop_point2d_lop_point3d.Point2D;

import java.util.Arrays;

public class Test2D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(4, 5);
        System.out.println(point2D);
        Point2D point2D1 = new Point2D(3.0f, 5.0f);
        System.out.println(point2D1);
        System.out.println(point2D1.getX());
        System.out.println(point2D1.getY());
        System.out.println(Arrays.toString(point2D1.getXY()));
        point2D1.setXY(4, 10);
        System.out.println(point2D1);

    }
}
