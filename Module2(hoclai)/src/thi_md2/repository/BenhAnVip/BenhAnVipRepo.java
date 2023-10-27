package repository.BenhAnVip;

import model.BenhAnVip;
import readFile.ReadFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BenhAnVipRepo implements IBenhAnVipRepo {
    private final String FILE_PATH= "D:\\Thi_md2\\Thi_md2\\src\\data\\BenhAnVip.csv";
    private List<BenhAnVip> benhAnVipLists = new ArrayList<>();
    private Scanner scanner= new Scanner(System.in);
    private ReadFile readFile = new ReadFile();

    @Override
    public void them(BenhAnVip benhAnVip) {
        int lastID = 0;
        if (benhAnVipLists.size()>0){
            lastID = benhAnVipLists.get(benhAnVipLists.size()-1).getMabenhan();
        }
        benhAnVip.setMabenhan(lastID+1);
        benhAnVipLists.add(benhAnVip);
        writeFile(Collections.singletonList(benhAnVip),FILE_PATH,true);
    }
    public void writeFile(List<BenhAnVip> benhAnVipList, String filePath, boolean append) {
        File file = new File(filePath);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (BenhAnVip benhAnVip : benhAnVipLists) {
                String line = benhAnVip.getSothutu() + "," + benhAnVip.getMabenhan() + "," + benhAnVip.getTenbenhnhan() + "," + benhAnVip.getNgaynhapvien()+ "," + benhAnVip.getNgayravien()+ "," + benhAnVip.getLydobenh()+ "," + benhAnVip.getViptype();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + e.getMessage());
        }
    }

    public BenhAnVipRepo(){
        benhAnVipLists = danhSach();
    }

    @Override
    public List danhSach() {
        List<BenhAnVip> lists = new ArrayList<>();
        List<String> strings = readFile.ReadFile(FILE_PATH);
        for (String str : strings) {
            String[] temp = str.split(",");
            int sothutu = Integer.parseInt(temp[0]);
            int mabenhan = Integer.parseInt(temp[1]);
            String tenbenhnhan = temp[2];
            String ngaynhapvien = temp[3];
            String ngayravien = temp[4];
            String lydobenh = temp[5];
            String viptype =temp[6];
            BenhAnVip benhAnVip = new BenhAnVip(sothutu,mabenhan,tenbenhnhan,ngaynhapvien,ngayravien,lydobenh,viptype);
            lists.add(benhAnVip);

        }
        return lists;
    }

    @Override
    public List findAll() {
        return benhAnVipLists;
    }

    @Override
    public void xoa(int id) {
        benhAnVipLists = danhSach();
        BenhAnVip benhAnVipToRemove = null;

        for (BenhAnVip benhAnVip : benhAnVipLists) {
            if (benhAnVip.getMabenhan()== id) {
                benhAnVipToRemove = benhAnVip;
                break;
            }
        }

        if (benhAnVipToRemove != null) {
            benhAnVipLists.remove(benhAnVipToRemove);
            writeFile(benhAnVipLists, FILE_PATH, false);
        }
    }

    @Override
    public void timKiemID(int id) {
        for (BenhAnVip benhAnVip: benhAnVipLists){
            if (benhAnVip.getMabenhan()==id){
                System.out.println(benhAnVip);
            }
        }
    }

    @Override
    public void tinKiemTen(String name) {
        for (BenhAnVip benhAnVip : benhAnVipLists){
            if (benhAnVip.getTenbenhnhan().equals(name)){
                System.out.println(benhAnVip);
                System.out.println(benhAnVip);
            }
        }

    }
}
