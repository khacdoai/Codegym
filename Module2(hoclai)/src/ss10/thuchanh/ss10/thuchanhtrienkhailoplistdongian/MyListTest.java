package ss10.thuchanh.ss10.thuchanhtrienkhailoplistdongian;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        System.out.println("element 2: "+ listInteger.get(2));
        System.out.println("element 3: "+ listInteger.get(4));
        listInteger.add(5);
    }
}
