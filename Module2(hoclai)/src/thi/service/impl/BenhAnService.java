package thi.service.impl;

import thi.model.BenhAn;
import thi.model.BenhAnThuong;
import thi.model.BenhAnVip;
import thi.repository.impl.BenhAnRepository;
import thi.repository.impl.BenhAnThuongRepository;
import thi.repository.impl.BenhAnVipRepository;
import thi.service.IBenhAnService;

import java.util.List;
import java.util.Scanner;

public class BenhAnService implements IBenhAnService {
    BenhAnRepository benhAnRepository = new BenhAnRepository();
    BenhAn benhAnThuong = new BenhAnThuong();
    BenhAn benhAnVip = new BenhAnVip();
    BenhAnThuongRepository benhAnThuongRepository = new BenhAnThuongRepository();
    BenhAnVipRepository benhAnVipRepository = new BenhAnVipRepository();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void themmoi() {
        boolean flag = true;

        do {
            System.out.println("Chon chuc nang theo so (de tiep tuc): ");
            System.out.println(" 1.benh nhan thuong" +
                    "\n 2. benh nhan vip" +
                    "\n 3. thoat" );
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    int stt = benhAnThuong.getStt();
                    System.out.printf("Nhap ma benh an: ");
                    String mabenhan = scanner.nextLine();
                    System.out.println("Nhap ma benh nhan: ");
                    String mabenhnhan = scanner.nextLine();
                    System.out.println("Nhap ten benh nhan: ");
                    String tenbenhnhan = scanner.nextLine();
                    System.out.println("Ngay nhap vien : ");
                    String ngaynhapvien = scanner.nextLine();
                    System.out.println("Ngay ra  vien : ");
                    String ngayravien = scanner.nextLine();
                    System.out.println("Ly do nhap vien :");
                    String lydonhapvien = scanner.nextLine();
                    System.out.println("Nhap so tien :");
                    String sotien = scanner.nextLine();
                    BenhAnThuong benhAnThuong = new BenhAnThuong(stt,mabenhan,mabenhnhan,tenbenhnhan,ngaynhapvien,ngayravien,lydonhapvien,sotien);
                    benhAnThuongRepository.themmoi(benhAnThuong);
                    break;
                case 2:
                    int stt1 = benhAnVip.getStt();
                    System.out.printf("Nhap ma benh an: ");
                    String mabenhan1 = scanner.nextLine();
                    System.out.println("Nhap ma benh nhan: ");
                    String mabenhnhan1 = scanner.nextLine();
                    System.out.println("Nhap ten benh nhan: ");
                    String tenbenhnhan1 = scanner.nextLine();
                    System.out.println("Ngay nhap vien : ");
                    String ngaynhapvien1 = scanner.nextLine();
                    System.out.println("Ngay ra  vien : ");
                    String ngayravien1 = scanner.nextLine();
                    System.out.println("Ly do nhap vien :");
                    String lydonhapvien1 = scanner.nextLine();
                    System.out.println("Nhap loai vip :");
                    String loaivip = scanner.nextLine();
                    BenhAnVip benhAnVip = new BenhAnVip(stt1,mabenhan1,mabenhnhan1,tenbenhnhan1,ngaynhapvien1,ngayravien1,lydonhapvien1,loaivip);
                    benhAnVipRepository.themmoi(benhAnVip);
                    break;
                case 3:
                    flag = false;
            }
        }while (flag);
    }


    @Override
    public void xoa() {
        System.out.println("Nhap ma benh an can xoa: ");
        String mabenhan = scanner.nextLine();
        benhAnRepository.xoa(mabenhan);

    }

    @Override
    public void hienthi() {
                    List<BenhAn> benhAnList = benhAnRepository.hienthidanhsach();
                    for (int i = 0; i < benhAnList.size() ; i++) {
                        if(benhAnList.get(i) != null){
                            System.out.println((i+1) + "." + benhAnList.get(i));
                        }
                    }

    }
}
