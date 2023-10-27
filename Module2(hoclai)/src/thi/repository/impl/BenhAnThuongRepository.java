package thi.repository.impl;


import thi.model.BenhAn;
import thi.model.BenhAnThuong;
import thi.model.BenhAnVip;
import thi.repository.IBenhAnThuongRepository;
import thi.utill.ReadAndWriters;

import java.util.ArrayList;
import java.util.List;

public class BenhAnThuongRepository implements IBenhAnThuongRepository {
    private final String Link_benhan = "D:\\CODEGYM\\Module2(hoclai)\\src\\thi\\data\\benhAn.csv";
    BenhAn benhAn = new BenhAnVip();
    int stt = benhAn.getStt();

    @Override
    public void themmoi(BenhAnThuong benhAnThuong) {
        List<String> stringList = new ArrayList<>();
        stringList.add(benhAnThuong.GetToCSV());
        ReadAndWriters.writeToCSV(Link_benhan, stringList,true);
        tudongtang(benhAnThuong.getStt());

    }

    @Override
    public void xoa(String mabenhan) {

    }
    public int tudongtang(int stt){
        stt = benhAn.getStt();
        stt+=1;
        return stt;
    }



}
