package repository.BenhAnThuong;

import model.BenhAnThuong;
import readFile.ReadFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BenhAnThuongRepository implements IBenhAnThuongRepository {
    private final String FILE_PATH= "D:\\Thi_md2\\Thi_md2\\src\\data\\BenhAn.csv";
    private List<BenhAnThuong> benhAnThuongList = new ArrayList<>();
    private Scanner scanner= new Scanner(System.in);
    private ReadFile readFile = new ReadFile();
    @Override
    public void them(BenhAnThuong benhAnThuong) {
        int lastID = 0;
        if (benhAnThuongList.size()>0){
            lastID = benhAnThuongList.get(benhAnThuongList.size()-1).getMabenhan();
        }
        benhAnThuong.setMabenhan(lastID+1);
        benhAnThuongList.add(benhAnThuong);
        writeFile(Collections.singletonList(benhAnThuong),FILE_PATH,true);
    }
    public void writeFile(List<BenhAnThuong> benhAnThuongs, String filePath, boolean append) {
        File file = new File(filePath);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (BenhAnThuong benhAnThuong : benhAnThuongList) {
                String line = benhAnThuong.getSothutu() + "," + benhAnThuong.getMabenhan() + "," + benhAnThuong.getTenbenhnhan() + "," + benhAnThuong.getNgaynhapvien()+ "," + benhAnThuong.getNgayravien()+ "," + benhAnThuong.getLydobenh()+ "," + benhAnThuong.getInlibrary();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + e.getMessage());
        }
    }

    public BenhAnThuongRepository(){
        benhAnThuongList = danhSach();
    }
//hiệnt thị danh sách
    @Override
    public List danhSach() {
        List<BenhAnThuong> lists = new ArrayList<>();
        List<String> strings = readFile.ReadFile(FILE_PATH);
        for (String str : strings) {
            String[] temp = str.split(",");
            int sothutu = Integer.parseInt(temp[0]);
            int mabenhan = Integer.parseInt(temp[1]);
            String tenbenhnhan = temp[2];
            String ngaynhapvien = temp[3];
            String ngayravien = temp[4];
            String lydobenh = temp[5];
            double inlibrary = Double.parseDouble(temp[6]);
            BenhAnThuong benhAnThuong = new BenhAnThuong(sothutu,mabenhan,tenbenhnhan,ngaynhapvien,ngayravien,lydobenh,inlibrary);
            lists.add(benhAnThuong);

        }
        return lists;
    }

    @Override
    public List findAll() {
        return benhAnThuongList;
    }
///ketthuc
    @Override
    public void xoa(int id) {
        benhAnThuongList = danhSach();
        BenhAnThuong benhAnThuongToRemove = null;

        for (BenhAnThuong benhAnThuong : benhAnThuongList) {
            if (benhAnThuong.getMabenhan()== id) {
                benhAnThuongToRemove = benhAnThuong;
                break;
            }
        }

        if (benhAnThuongToRemove != null) {
            benhAnThuongList.remove(benhAnThuongToRemove);
            writeFile(benhAnThuongList, FILE_PATH, false);
        }
    }

    @Override
    public void timKiemID(int id) {
        for (BenhAnThuong employee: benhAnThuongList){
            if (employee.getMabenhan()==id){
                System.out.println(employee);
            }
        }
    }

    @Override
    public void tinKiemTen(String name) {
        for (BenhAnThuong benhAnThuong : benhAnThuongList){
            if (benhAnThuong.getTenbenhnhan().equals(name)){
                System.out.println(benhAnThuong);
            }
        }

    }
}
