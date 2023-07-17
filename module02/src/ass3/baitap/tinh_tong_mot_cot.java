package ass3.baitap;

import java.util.Scanner;

public class tinh_tong_mot_cot {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] array;
        int row;
        System.out.print("enter row number : ");
        row = Integer.parseInt(scanner.nextLine());
        int col;
        System.out.print("enter column number : ");
        col = Integer.parseInt(scanner.nextLine());
        array = new int[row][col];
        for (int j = 0; j < array.length; j++){
            for (int z =0; z <array[j].length; z++){
                System.out.println("Nhập phần tử thứ " + (z+ 1) + " Của cột thứ " + (j+ 1) );
                array[j][z] = scanner.nextInt();
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Bạn muốn tính tổng của cột thứ ");
        int sumOfCol;
        sumOfCol = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < array.length; i++){
            sum += array[i][sumOfCol-1];
        }
        System.out.println("Tổng của cột là: " + sum);
    }
}
