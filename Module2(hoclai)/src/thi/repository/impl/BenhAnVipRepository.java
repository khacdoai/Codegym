package thi.repository.impl;

import thi.model.BenhAnThuong;
import thi.model.BenhAnVip;
import thi.repository.IBenhAnVipRepository;
import thi.utill.ReadAndWriters;

import java.util.ArrayList;
import java.util.List;

public class BenhAnVipRepository implements IBenhAnVipRepository {
    private final String Link_benhan = "D:\\CODEGYM\\Module2(hoclai)\\src\\thi\\data\\benhAn.csv";

    @Override
    public void themmoi(BenhAnVip benhAnVip) {
        List<String> stringList = new ArrayList<>();
        stringList.add(benhAnVip.GetToCSV());
        ReadAndWriters.writeToCSV(Link_benhan, stringList,true);

    }

    @Override
    public void xoa(String mabenhan) {

    }

    }
