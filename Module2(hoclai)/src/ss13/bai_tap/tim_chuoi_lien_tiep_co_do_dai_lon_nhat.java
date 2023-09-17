package ss13.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class tim_chuoi_lien_tiep_co_do_dai_lon_nhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi ");
        String chuoi = scanner.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i =0;i<chuoi.length();i++){
            if(list.size() > 1 && chuoi.charAt(i) <=list.getLast()&& list.contains(chuoi.charAt(i))){
                list.clear();
            }
            list.add(chuoi.charAt(i));
            if(list.size() >max.size()){
                max.clear();
                max.addAll(list);
            }
        }
        for (Character ch : max){
            System.out.print(ch);
        }
        System.out.println();

    }
}
