package ass4.baitap.phuongtrinhbachai;

public class QuadraticEquation {
    double a,b,c;
    QuadraticEquation(){

    }
    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getterA(){
        return a;
    }
    public double getterB(){
        return b;
    }
    public double getterC(){
        return c;
    }
    public double getDiscriminant(){
        return b * b - 4 * ( a * c);
    }
    public double getRoot1(){
        return (-b + Math.pow(this.getDiscriminant(),0.5)/2*a);
    }
    public double getRoot2(){
        return (-b - Math.pow(this.getDiscriminant(),0.5)/2*a);
    }
}
