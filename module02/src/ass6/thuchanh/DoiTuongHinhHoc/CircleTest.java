package ass6.thuchanh.DoiTuongHinhHoc;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);
        circle1 = new Circle(3.0);
        System.out.println(circle1);
        circle1 = new Circle(2.0,"red",false);
        System.out.println(circle1);
    }
}
