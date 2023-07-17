package ass5.thuchanh;

public class Static_method {
    private int rollno;
    private String name;
    private static String colleger = "BBDIT";

    Static_method(int r, String n){
        rollno = r;
        name = n;
    }
    static void change() {
        colleger = "CODEGYM";
    }
    void display(){
        System.out.println(rollno + " " + name + " " + colleger);
    }
}

