package ass10.bai_tap.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList dd = new MyLinkedList(10);
        dd.add(1,12);
        dd.addFirst(56);
        dd.add(3,12);
        dd.addLast(5);
        dd.addLast(42);
        dd.remove(3);
        dd.remove(1);
        dd.remove(1);
        dd.addLast(23);
        dd.printList();
        System.out.println("Số lượng phần tử trong danh sách " + dd.size());
    }
}
