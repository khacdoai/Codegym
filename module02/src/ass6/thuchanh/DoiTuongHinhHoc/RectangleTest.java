package ass6.thuchanh.DoiTuongHinhHoc;

public class RectangleTest {
    public static void main (String[] args){
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(1.8,3.0);
        System.out.println(rectangle);
        rectangle = new Rectangle(5,4,"yellow",false);
        System.out.println(rectangle);
    }
}
