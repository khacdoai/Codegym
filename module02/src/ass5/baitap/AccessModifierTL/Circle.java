package ass5.baitap.AccessModifierTL;

public class Circle {
    private double radius = 1.0;
    private String color = "Red";

    public Circle(){

    }
    public Circle(double radius){

    }

    protected double getRadius() {
        return radius;
    }

    protected String getColor() {
        return color;
    }
}
