package ass5.thuchanh;

public class testStaticMethod {
    public static void main(String[] args) {
        Static_method.change();

        Static_method s1 = new Static_method(111, "Hoang");
        Static_method s2 = new Static_method(222, "khanh");
        Static_method s3 = new Static_method(333, "Nam");

        s1.display();
        s2.display();
        s3.display();
    }
}
