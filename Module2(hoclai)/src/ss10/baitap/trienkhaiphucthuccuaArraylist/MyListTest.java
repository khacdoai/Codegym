package ss10.baitap.trienkhaiphucthuccuaArraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(10);
        myList.add(1,45);
        myList.add(2,12);
        myList.add(5,6);
        myList.remove(2);
        myList.clear();
        System.out.println(myList);
        System.out.println(myList.size);

    }
}
