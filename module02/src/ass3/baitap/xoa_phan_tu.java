package ass3.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class xoa_phan_tu {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,0};
        int[] newArr = new int[8];
        int index = 0;
        System.out.println("mảng trước khi xóa phần tử ");
        System.out.println(Arrays.toString(numbers));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá trị cần xóa ");
        int x = scanner.nextInt();
        for (int i = 0; i < numbers.length; i++){
            if (x == numbers[i]){
                for (int j =i; j < numbers.length-1; j++ ){
                    numbers[j] = numbers[(j+1)];

                }
            }

        }
        System.out.println("mảng sau khi xóa phần tử ");
        System.out.println(Arrays.toString(numbers));
    }
}
