package ss15.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class su_dung_lop_arrayIndexOutOfBoundsException {
    public Integer[] createRandom(){
        Random rd = new Random();
        Integer[] arr = new  Integer[100];
        System.out.println("Danh sách phần tử của mảng: ");
        for (int i = 0; i<100; i++){
            arr[i] = rd.nextInt(100);
            System.out.println(arr[i]+ " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        su_dung_lop_arrayIndexOutOfBoundsException su_dung_lop_arrayIndexOutOfBoundsException = new su_dung_lop_arrayIndexOutOfBoundsException();

       Integer[] arr = su_dung_lop_arrayIndexOutOfBoundsException.createRandom();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Vui lòng nhập chỉ số của một phần tử bất kì");
        int x = scanner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số 5" + x + "la" + arr[x]);

        }catch (IndexOutOfBoundsException e){
            System.out.println("Chỉ số vượt quá giới hạn của mảng");
        }

    }

}
