package ss16.mvc.common;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFile {

    public static void writeFile(String src, String value, boolean append) {
        File file = new File(src);
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(value);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file");
            }
        }

    }

    public static List<String> readFile(String src) {
        List<String> strings = new ArrayList<>();
        File file = new File(src);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
             bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại");
        } catch (IOException e) {
            System.out.println("Lỗi đoc file");
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file");
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        File file = new File("src/ss16/mvc/data/test.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("A0723I1");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file");
            }
        }


//       FileReader fileReader = null;
//        try {
//            fileReader = new FileReader(file);
//            int temp;
//            while ((temp = fileReader.read()) != -1) {
//                System.out.println((char) temp);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File không tồn tại");
//        } catch (IOException e) {
//            System.out.println("Lỗi đọc dữ liệu");
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException e) {
//                System.out.println("Lỗi đóng file");
//            }
//        }
    }
}
