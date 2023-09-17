package ss13.bai_tap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class tim_chuoi_tang_dan_co_do_dai_lon_nhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        for (int i=0; i<string.length();i++){
            LinkedList<Character> list = new LinkedList<>();

            list.add(string.charAt(i));
            for (int j=i+1; j<string.length();i++){
                if(string.charAt(j) > list.getLast()){
                    list.add(string.charAt(j));
                }
            }
            if (list.size() >max.size()){
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character ch: max){
            System.out.println(ch);
        }
        System.out.println();
    }
//    Độ phức tạp thuật toán O(n^2)

    }
