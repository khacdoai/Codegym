package ass15.baitap;

import java.util.Scanner;

public class TriangleChecked {
    public void checkTriangle(int a , int b ,int c) throws TriangleException{
        if(a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException("Lỗi Tam giác không hợp lệ: Các cạnh bé hơn hoặc bằng 0");
        }else if(a + b <= c || a + c <= b || b + c <= a){
            throw new TriangleException("Lỗi Tam giác không hợp lệ: Tổng 2 cạnh lớn hơn cạnh còn lại");
        } else {
            System.out.println("Tam giác hợp lệ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TriangleChecked triangle = new TriangleChecked();

        try{
            System.out.println("Nhập cạnh a");
            int a = Integer.parseInt(input.nextLine());
            System.out.println("Nhập cạnh b");
            int b = Integer.parseInt(input.nextLine());
            System.out.println("Nhập cạnh c");
            int c = Integer.parseInt(input.nextLine());
            try {
                triangle.checkTriangle(a, b, c);
            } catch (TriangleException e) {
                System.out.println(e.getMessage());
                System.out.println("Hãy nhập cạnh dương");
            }
        } catch (Exception e){
            System.out.println("Hãy nhập đúng dữ liệu");
        }
        input.close();
    }
}
