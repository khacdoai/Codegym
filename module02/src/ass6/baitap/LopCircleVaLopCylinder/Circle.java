package ass6.baitap.LopCircleVaLopCylinder;

import ass6.thuchanh.DoiTuongHinhHoc.Shape;

public class Circle {
    private double radius = 1.0;
    private String color = "black";
    public Circle(){}
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double Area(){
        return  radius * radius * Math.PI;
    }
    public String toString(){
        return "A Circle with radius = "
                + getRadius()
                + " and color "
                + getColor();
    }

}
