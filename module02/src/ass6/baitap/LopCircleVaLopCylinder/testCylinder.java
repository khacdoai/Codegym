package ass6.baitap.LopCircleVaLopCylinder;

public class testCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(3);
        System.out.println(cylinder);
        cylinder = new Cylinder(4, 5, "yellow" );
        System.out.println(cylinder);
    }
}
