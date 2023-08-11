package ass14.baitap.cai_dat_thuat_toan_sap_xep_chen;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int space , x ;
        for(int i = 1 ; i < arr.length ; i ++){
            x = arr[i];
            space = i;

            while(space > 0 && x < arr[space - 1 ]){
                arr[space] = arr[space - 1];
                space --;
            }
            arr[space] = x ;
        }

    }
    public static void main(String[] args) {
        int[] arr = {5,3,7,8,1,2,9,6,4};
        System.out.println("Before");
        System.out.println(Arrays.toString(arr));
        System.out.println("After");
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
