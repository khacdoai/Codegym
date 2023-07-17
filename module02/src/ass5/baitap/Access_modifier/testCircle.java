package ass5.baitap.Access_modifier;

import ass5.baitap.Access_modifier.Circle;

public class testCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(2.5);

        // Truy cập phương thức getRadius()
        double radius = circle.getRadius();
        System.out.println("Radius: " + radius);

        // Truy cập phương thức getArea()
        double area = circle.getArea();
        System.out.println("Area: " + area);
    }

}
