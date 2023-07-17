package ass11.baitap.CircularLinkedQueue;

public class Main {
    public static void main(String[] args) {
        CircularLinkedQueue<Integer> queue = new CircularLinkedQueue<>();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
    }
}
