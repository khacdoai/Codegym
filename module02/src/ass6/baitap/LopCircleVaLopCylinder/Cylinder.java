package ass6.baitap.LopCircleVaLopCylinder;

public class Cylinder extends Circle {
    private double height = 1.0;
    public Cylinder(){

    }
    public Cylinder(double height){

    }
    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double Area() {
        return 2 * getRadius() * height * Math.PI;
    }

    @Override
    public String toString() {
        return "A Cylinder height = " +
                 height +
                super.toString();
    }
}
