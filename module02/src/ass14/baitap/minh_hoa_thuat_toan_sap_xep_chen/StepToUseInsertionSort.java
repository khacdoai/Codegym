package ass14.baitap.minh_hoa_thuat_toan_sap_xep_chen;

import java.util.Arrays;
import java.util.Scanner;

public class StepToUseInsertionSort {
    public static void insertionSort(int[] arr){
        int space , x ;
        for(int i = 1; i < arr.length ; i++ ){
            x = arr[i];
            space = i ;

            while(space > 0 && x < arr[space - 1] ){
                arr[space] = arr[space - 1];
                space--;
            }
            arr[space] = x;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i = 0 ; i < arr.length ; i ++){
            System.out.println("Enter element at index " + i);
            arr[i] = input.nextInt();
        }
        System.out.println("Before");
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After");
        System.out.println(Arrays.toString(arr));
    }
}
