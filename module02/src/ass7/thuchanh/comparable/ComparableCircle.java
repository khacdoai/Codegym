package ass7.thuchanh.comparable;


import ass6.thuchanh.DoiTuongHinhHoc.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    private double radius;

    public ComparableCircle(){

    }
    public ComparableCircle(double radius){
        super(radius);
    }
    public ComparableCircle(double radius, String color, boolean filled){
        super(radius, color,filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return -1;
    }
}
