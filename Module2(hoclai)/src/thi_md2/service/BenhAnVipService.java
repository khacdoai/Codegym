package service;

import model.BenhAnVip;
import repository.BenhAnVip.BenhAnVipRepo;
import repository.BenhAnVip.IBenhAnVipRepo;

import java.util.List;
import java.util.Scanner;

public class BenhAnVipService implements IBenhAnVipService{
    private static IBenhAnVipRepo iBenhAnVipRepo = new BenhAnVipRepo();
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void them() {
        BenhAnVip benhAnVip = this.getThongTin();
        iBenhAnVipRepo.them(benhAnVip);
        System.out.println("Thêm mới thành công");
        danhSach();
    }

    private BenhAnVip getThongTin() {
        System.out.println("Nhập vào thông tin điện thoại chính hãng: ");
        System.out.println("Số thứ tự: ");
        int sothutu = Integer.parseInt(scanner.nextLine());

        int id = 0;

        System.out.println("Tên: ");
        String ten = scanner.nextLine();

        System.out.println("Ngày nhập viện:");
        String ngaynhapvien = scanner.nextLine();

        System.out.println("Ngày ra viện: ");
        String ngayravien = scanner.nextLine();

        System.out.println("Lý do bệnh: ");
        String lidobenh = scanner.nextLine();

        System.out.println("Loại vip: ");
        String loaivip = scanner.nextLine();

        BenhAnVip benhAnVip = new BenhAnVip(sothutu,id,ten,ngaynhapvien,ngayravien,lidobenh,loaivip);
        return benhAnVip;
    }

    @Override
    public void danhSach() {
        List<BenhAnVip> benhAnThuongList = iBenhAnVipRepo.findAll();
        for (BenhAnVip benhAnVip : benhAnThuongList) {
            System.out.println(benhAnVip);
        }
    }

    @Override
    public void xoa(int id) {
        iBenhAnVipRepo.xoa(id);
        danhSach();
    }

    @Override
    public void timKiemID(int id) {
        iBenhAnVipRepo.timKiemID(id);
    }

    @Override
    public void tinKiemTen(String name) {
        iBenhAnVipRepo.tinKiemTen(name);
    }
}
