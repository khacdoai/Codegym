package ass7.baitap.interface_colorable_cho_cac_lop_hinh_hoc;

public class Circle implements Resizeable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void resize(double percent) {
        radius *= (1 + percent / 100);
    }
}

public class Rectangle implements Resizeable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    @Override
    public void resize(double percent) {
        length *= (1 + percent / 100);
        width *= (1 + percent / 100);
    }
}

 public class Square implements Resizeable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public void resize(double percent) {
        side *= (1 + percent / 100);
    }
}
}
