package ss14.baitap;

import java.util.Arrays;

public class illustrates_insertion_sort {
    public static void main(String[] args) {
        int [] array = {1,3,6,15,9,20,8,2,12};
        System.out.println("Mang sau khi sap xep "+insertionSort(array));
    }
    public static String insertionSort(int[] array){
        int x;
        int pos;
        System.out.println("Mang ban dau "+Arrays.toString(array));

        for (int i = 1 ; i < array.length; i++){
                x = array[i];
                pos =i;
            System.out.println("gia tri x la " + x + " o vi tri thu " + pos);
            while (0<pos && array[pos-1] > x){
                array[pos] = array[pos-1];
                System.out.println("gia tri " + x + " o vi tri thu " + pos );
                pos--;
            }
            array[pos] = x;
            System.out.println(Arrays.toString(array));
        }
        return Arrays.toString(array);
    }
}
