package ss12;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class kiem_tra_so_lan_xuat_hien_tu_trong_chuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuoi");
        String text = scanner.nextLine();
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split("\\s+");
        for (String word: words){
            word = word.toLowerCase(Locale.ROOT);
            if(map.containsKey(word)){
                int cout = map.get(word);
                map.put(word,cout+1);
            }else {
                map.put(word,1);
            }
        }
        System.out.println("Nhập ki tu can dem");
        String s = scanner.nextLine();
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getKey().equals(s)) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}
