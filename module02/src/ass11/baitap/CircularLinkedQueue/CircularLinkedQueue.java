package ass11.baitap.CircularLinkedQueue;

public class CircularLinkedQueue {
    private Node<T> front;
    private Node<T> rear;

    public CircularLinkedQueue() {
        front = null;
        rear = null;
    }

    public void enQueue(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            rear.setNext(front); // Circular linking
        } else {
            rear.setNext(newNode);
            newNode.setNext(front);
            rear = newNode;
        }
    }

    public T deQueue() {
        if (isEmpty()) {
            return null;
        }

        T value = front.getValue();

        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.getNext();
            rear.setNext(front);
        }

        return value;
    }

    public boolean isEmpty() {
        return front == null;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
