package ass3.baitap;

import java.util.Scanner;

public class demkituchuoi {
    public static void main(String[] args) {
        String a = "Hello Work";
        char b = 'l';

        int cout = 0;
        for (int i = 0; i < a.length(); i++ ){
            if (a.charAt(i) == b ){
                cout++;

            }
        }
        System.out.println("Số lần kí tự " + b + " xuât hiện trong chuỗi là : " + cout);
    }
}
