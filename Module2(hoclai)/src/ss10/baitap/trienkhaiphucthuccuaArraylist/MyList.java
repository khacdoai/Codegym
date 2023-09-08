package ss10.baitap.trienkhaiphucthuccuaArraylist;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList() {
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }


    public MyList(int capacity){
            if(capacity >=0) {
                elements = new Object[DEFAULT_CAPACITY];
            }
    }
    private void ensureCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    void add (int index , E element ){
        if (size == elements.length){
            ensureCapa();
        }
        for (int i =0; i<elements.length;i++){
            if((i+1) == index){
                elements[i] = element;
                size++;
            }
        }
    }

    E remove (int index){
        for (int i =0; i<elements.length;i++){
            if((i+1) == index){
                elements[i] = null;
            }
        }
        return (E) elements;
    }
    int Size(){
        return size;
    }
    public int indexOf(E e) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public E clone() {
        return (E) Arrays.copyOf(elements,elements.length);
    }
    public E get(int i){
        if (i >=size || i < 0){
            throw new IndexOutOfBoundsException("Index: " + i + ", Size"+ i);

        }
        return (E) elements[i];
    }
    public Boolean contains (E e) {
        for (int i = 0; i < size-1; i++) {
            if(elements[i] == e) {
                return true;
            }
        }
        return false;
    }
    private void ensureCapacity(int minCapacity) {
        if (minCapacity <0) {
            throw new IllegalArgumentException("minCapacity: " +minCapacity);
        } else {
            int newSize = minCapacity + elements.length;
                elements = Arrays.copyOf(elements,newSize);
        }
    }
    public Boolean add (E e) {
        if (elements.length == size) {
            ensureCapacity(3);
        }
        elements[size] =e;
        return true;
    }
    public void clear () {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
            size = 0;
        }
    }


}
