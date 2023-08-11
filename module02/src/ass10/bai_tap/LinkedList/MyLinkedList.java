package ass10.bai_tap.LinkedList;

import org.w3c.dom.Node;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holed;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holed = temp.next;
        temp.next = new Node(element);
        temp.next.next = holed;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        numNodes++;

    }
public void remove(int index){
    if (index < 0 || index >= numNodes) {
        throw new IndexOutOfBoundsException("Vị trí không hợp lệ.");
    }
    if (index == 0) {
        head = head.next;
    } else {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }
    numNodes--;
}
    public void printList() {
        Node temp =head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    // Truy Cập 1 phần tử trong danh sách
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Vị trí không hợp lệ.");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (E) current.data;
    }
    public int size(){
        return numNodes+1;
    }
    public MyLinkedList<E> clone(){
        MyLinkedList<E> clonelist = new MyLinkedList<>(head.data);
        Node current = head.next;
        while (current != null){
            clonelist.addLast(current.data);
            current = current.next;
        }
        return clonelist;
    }
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int indexOf(Object o) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}
