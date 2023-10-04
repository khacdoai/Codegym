package ss8_mvc.util;

import ss8_mvc.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    // ghi file
    public static void writeToCSV(String filePath, List<String> stringList,boolean append){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter =null;
        try {
            fileWriter = new FileWriter(filePath,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string:stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // đọc file
    public static List<String> readCSVFile(String filePath){
        List<String> stringList = new ArrayList<>();
        // đọc file
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader =new BufferedReader(fileReader);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

   // ghi một list vào trong file binary
    public static void writeListObjectToCSV(String filePath, List<Student> studentList){
      File file = new File(filePath);
      FileOutputStream fileOutputStream = null;
      ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 // đọc từ file binary thành một list
    public  static List<Student> readObjecListStudent(String filePath){
        List<Student> studentList = new ArrayList<>();
        File file = new File(filePath);
        if (file.length()>0){
            FileInputStream fileInputStream =null;
            ObjectInputStream objectInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                studentList = (List<Student>) objectInputStream.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return  studentList;
    }
}
