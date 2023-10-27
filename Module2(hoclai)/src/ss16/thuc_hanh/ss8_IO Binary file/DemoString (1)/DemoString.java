
import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class DemoString {
    public static void main(String[] args) {
//        String s1= "hải";
//        String s2= "hải";
//        String s3= new String("hải");
//        String s4= new String("hải");
//
//        System.out.println(s1==s2);
//        System.out.println(s1==s3);
//        System.out.println(s3==s4);
//
//        String string1 = new String("hello");
//        String string2 = string1;
//        string1 =string1 +"hải";
//        System.out.println(string1);
//        System.out.println(string2);

//        StringBuffer stringBuffer = new StringBuffer("hello");
//        StringBuffer stringBuffer1 = stringBuffer;
//        stringBuffer.append("hải");
//        System.out.println(stringBuffer);
//        System.out.println(stringBuffer1);

        Scanner scanner = new Scanner(System.in);
        String regex ="^[AC]\\d{4}[GI]\\d$";
        String regePhoneNumber ="^((\\(\\+84\\))|0)\\d{9}$";
        String regexName ="^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";

        System.out.println("nhập tên lớp cần kiểm tra");
        String className = scanner.nextLine();
        boolean result = className.matches(regex);
        System.out.println(" result : " +result);
        // regex       số điện    thoai    việt      name
        String string = "hello         world    viet           nam---Chanh";
        String[] arr = string.split("\\s+");
        System.out.println("số lương " + arr.length);


    }
}
