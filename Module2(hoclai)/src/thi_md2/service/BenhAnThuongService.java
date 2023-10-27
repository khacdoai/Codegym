package service;

import model.BenhAnThuong;
import repository.BenhAnThuong.BenhAnThuongRepository;
import repository.BenhAnThuong.IBenhAnThuongRepository;

import java.util.List;
import java.util.Scanner;

public class BenhAnThuongService implements IBenhAnThuongService {
    private static IBenhAnThuongRepository iBenhAnThuongRepository = new BenhAnThuongRepository();
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void them() {
        BenhAnThuong benhAnThuong = this.getThongTin();
        iBenhAnThuongRepository.them(benhAnThuong);
        System.out.println("Thêm mới thành công");
        danhSach();
    }

    private BenhAnThuong getThongTin() {
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

        System.out.println("Giá: ");
       double inlibrary = Double.parseDouble(scanner.nextLine());

        BenhAnThuong benhAnThuong = new BenhAnThuong(sothutu,id,ten,ngaynhapvien,ngayravien,lidobenh,inlibrary);
        return  benhAnThuong;
    }

    @Override
    public void danhSach() {
        List<BenhAnThuong> benhAnThuongList = iBenhAnThuongRepository.findAll();
        for (BenhAnThuong benhAnThuong : benhAnThuongList) {
            System.out.println(benhAnThuong);
        }
    }

    @Override
    public void xoa(int id) {
        iBenhAnThuongRepository.xoa(id);
        danhSach();
    }

    @Override
    public void timKiemID(int id) {
        iBenhAnThuongRepository.timKiemID(id);
    }

    @Override
    public void tinKiemTen(String name) {
        iBenhAnThuongRepository.tinKiemTen(name);
    }
}
