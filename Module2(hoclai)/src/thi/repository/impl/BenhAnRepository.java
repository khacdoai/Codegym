package thi.repository.impl;

import thi.model.BenhAn;
import thi.model.BenhAnThuong;
import thi.model.BenhAnVip;
import thi.repository.IBenhAnRepository;
import thi.utill.ReadAndWriters;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class BenhAnRepository implements IBenhAnRepository<BenhAn> {
    private final String Link_benhan = "D:\\CODEGYM\\Module2(hoclai)\\src\\thi\\data\\benhan.csv";

    @Override
    public void themmoi(BenhAn benhAn) {
        List<String> stringList = new ArrayList<>();
        stringList.add(benhAn.GetToCSV());
        ReadAndWriters.writeToCSV(Link_benhan, stringList, true);

    }

    @Override
    public void xoa(String mabenhan) {
        List<BenhAn> benhAnList = hienthidanhsach();
        for (int i = 0; i < benhAnList.size(); i++) {
            if (benhAnList.get(i).getMaBehAn().equals(mabenhan)) {
                benhAnList.remove(i);
            }
            break;
        }
        List<String> stringList = new ArrayList<>();
        for (BenhAn benhAn : benhAnList) {
            stringList.add(benhAn.GetToCSV());
        }
        ReadAndWriters.writeToCSV(Link_benhan, stringList, false);


    }

    public List<BenhAn> hienthidanhsach() {
        List<BenhAn> benhAnList = new ArrayList<>();
        List<String> stringList = ReadAndWriters.readCSVFile(Link_benhan);
        String[] array = null;
        for (String string : stringList) {
            array = string.split(",");
            if (array[5].equals("vip I") || array[5].equals("vip II") ||array[5].equals("vip III")) {
                BenhAnVip benhAnVip = new BenhAnVip(Integer.parseInt(array[0]), array[1], array[2], array[3], (array[4]), (array[5]),array[6],array[7]);
                benhAnList.add(benhAnVip);
            } else {
                BenhAnThuong benhAnThuong = new BenhAnThuong(Integer.parseInt(array[0]), array[1], array[2], array[3], (array[4]), array[5],array[6],array[7]);
                benhAnList.add(benhAnThuong);
            }

        }
        return benhAnList;
    }
}
