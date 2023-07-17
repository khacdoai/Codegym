package ass6.baitap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle{
    public double height;
    public double volume;

    public Cylinder(double height,double volume, double radius, String color) {
        super(radius,color);
        this.height = height;

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * getRadius() * getRadius() * height;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", volume=" + getVolume() +
                ", radius=" + getRadius() +
                ", color='" + color + '\'' +
                '}';
    }
}
