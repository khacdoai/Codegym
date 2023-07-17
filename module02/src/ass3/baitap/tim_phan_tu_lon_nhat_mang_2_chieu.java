package ass3.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class tim_phan_tu_lon_nhat_mang_2_chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số dong cua ma trận");
         int dong = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số cột của ma trận");
        int cot = Integer.parseInt(scanner.nextLine());
        int[][] mang2chieu2 = new int[dong][cot];
        for (int a = 0; a < mang2chieu2.length;a++){
            for (int x =0; x < mang2chieu2[a].length; x++){
                System.out.print("nhập giá trị dòng thứ " + a + " cột thứ " + x + "của ma trận ");

            }
        }
        int[][] mang2chieu = {{1,2,3},{4,5,6},{6,7,8},{9,10,11},{11,12,13}};
        int max = mang2chieu[0][0];
        int i = 0;
        int z = 0;
       for ( i=0; i < mang2chieu.length; i++ ){
           for ( z =0; z <mang2chieu[i].length;z++){
               if (mang2chieu[i][z] > max){
                   max = mang2chieu[i][z];
               }

           }
       }
        System.out.println(max);
        System.out.println("giá trị lớn nhất nằm ở vị trí dòng thứ "  + i +" cột thứ " + z );

    }




}
