package com.example.thi_ket_thuc_module3.model;

import java.sql.Date;

public class TheMuonSach {
    private int id;
    private String maMuonSach;
    private boolean trangThai;
    private Date ngayMuon;
    private Date ngayTra;

    public TheMuonSach() {
    }

    public TheMuonSach(int id, String maMuonSach, boolean trangThai, Date ngayMuon, Date ngayTra) {
        this.id = id;
        this.maMuonSach = maMuonSach;
        this.trangThai = trangThai;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
}
