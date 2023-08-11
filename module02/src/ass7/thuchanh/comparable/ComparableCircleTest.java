package ass7.thuchanh.comparable;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] comparableCircles = new ComparableCircle[3];
        comparableCircles[0] = new ComparableCircle(3.6);
        comparableCircles[1] = new ComparableCircle();
        comparableCircles[2] = new ComparableCircle(3.6, "red", true);
        System.out.println("Pre-sorted");
        for (ComparableCircle circle : comparableCircles){
            System.out.println(circle);
        }
        Arrays.sort(comparableCircles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : comparableCircles){
            System.out.println(circle);
        }
    }

}
