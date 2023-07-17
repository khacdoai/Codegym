package ass10.bai_tap;

import java.util.Arrays;

public class MyListA<E>{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public Object[] elements;

    //constructor không tham số khởi tạo
    public MyListA() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //constructor có tham số khởi tạo
    public MyListA(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
    }

    private int getSize(){
        return this.size;
    }

    // method xóa tất cả phần tử trong ArrayList
    private void clear(){
        this.size = 0;
        for(int i=0; i< elements.length; i++){
            elements[i] = null;
        }
    }


    private boolean add(E element){
        if(elements.length == size){
            this.ensureCapacity(5);
        }
        size++;
        elements[size] = element;
        return true;
    }


    private void add(E element, int index){
        if(index >= elements.length){
            throw new IllegalArgumentException("index : " + index);
        } else if(elements.length == size) {
            this.ensureCapacity(5);
        }
        if(elements[index] == null){
            elements[index] = element;
            size++;
        } else {
            for(int i = size+1 ; i >= index ; i--){
                elements[i] = elements[i -1];
            }
            elements[index] = element;
            size++;
        }
    }

    //Method lấy index
    public int indexOf(E element){
        int index = -1;
        for(int i = 0 ; i < size ; i++){
            if(this.elements[i].equals(element)){
                return i;
            }
        }
        return index;
    }


    // method contains kiểm tra 1 phần tử có nằm trong mảng MyarrayList Hay không?
    public boolean contains(E element){
        return this.indexOf(element) >= 0 ;
    }

    //method sao chép hay còn gọi là tạo ra bảng sao từ arrayList
    public MyListA<E> clone(){
        MyListA<E> v = new MyListA<>();
        v.elements= Arrays.copyOf(this.elements, this.size);
        v.size = this.size;
        return v;
    }

    public E remove(int index){
        if(index < 0 || index > elements.length){
            throw  new IllegalArgumentException("Error index " + index);
        }
        E element = (E) elements[index];
        for(int i = index ; i < size -1 ; i++){
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }

    private void ensureCapacity(int minCapacity){
        if(minCapacity >=0){
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity : " + minCapacity);
        }
    }
}
