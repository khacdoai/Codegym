package ass4.baitap.phuongtrinhbachai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the A:");
        double a = scanner.nextDouble();
        System.out.print("Enter the B:");
        double b = scanner.nextDouble();
        System.out.print("Enter the C:");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        if (quadraticEquation.getDiscriminant() > 0){
            System.out.println("The equation has tow roots" + quadraticEquation.getRoot1() +"and" + quadraticEquation.getRoot2());
        }else if (quadraticEquation.getDiscriminant() == 0){
            System.out.println("The equation has one root " + quadraticEquation.getRoot1());
        }else {
            System.out.println("The equation has no real roots");
        }
    }
}
