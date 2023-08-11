package ass13.tim_kiem_nhi_phan_su_dung_de_quy;

import java.util.Scanner;
import java.util.Stack;

public class AlgorithmFindByBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng:");
        int size = input.nextInt();
        int [] arrNum = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập giá trị cho mảng: ");
            arrNum[i] = input.nextInt();

        }
        Stack<Integer> minStack = new Stack<>();
        int min = arrNum[0];
        for (int i = 1; i < size ; i++) {
            for (int j = size-1; j >=0 ; j--) {
                if(arrNum[j]<min){
                    min = arrNum[i];
                }
            }
            minStack.push(min);
        }
    }
}
