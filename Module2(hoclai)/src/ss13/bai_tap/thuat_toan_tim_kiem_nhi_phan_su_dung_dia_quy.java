package ss13.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class thuat_toan_tim_kiem_nhi_phan_su_dung_dia_quy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng");
        int n = Integer.parseInt(scanner.nextLine());
        int[] mang = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " của mảng: ");
            mang[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(mang);
        System.out.println("Nhập giá trị cần tìm");
        int value = Integer.parseInt(scanner.nextLine());
        int result = binarySearch(mang, 0, n - 1, value);
        if (result == -1) {
            System.out.println("Không tìm thấy giá trị trong mảng");
        } else {
            System.out.println("Giá trị " + value + " được tìm thấy tại vị trí thứ " + result);
        }

    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (left <= right) {

            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (value > array[middle]) {
                return binarySearch(array, middle + 1, right, value);
            } else {
                return binarySearch(array, left, middle - 1, value);
            }
        }
        return -1;
    }
}
