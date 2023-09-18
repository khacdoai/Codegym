package ss14.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class Insertion_sort_settings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[]  array = new int[n];
        for (int i = 0;i<array.length;i++){
            System.out.println("nhập phần tử thứ " + (i+1) +"của mảng");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng sau khi sắp xếp "+insertionSort(array));
    }
    public static String insertionSort(int[] array){
        int x;
        int pos;
        System.out.println("Mang ban dau "+ Arrays.toString(array));

        for (int i = 1 ; i < array.length; i++){
            x = array[i];
            pos =i;
            while (0<pos && array[pos-1] > x){
                array[pos] = array[pos-1];
                pos--;
            }
            array[pos] = x;
        }
        return Arrays.toString(array);
    }
}
