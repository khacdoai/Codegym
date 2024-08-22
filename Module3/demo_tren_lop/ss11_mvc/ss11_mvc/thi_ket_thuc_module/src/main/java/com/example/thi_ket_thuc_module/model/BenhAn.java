package com.example.thi_ket_thuc_module.model;

public class BenhAn {
    private int idBenhAn;
    private int idBenhNhan;
    private String maBenhAn;

    public BenhAn() {
    }

    public BenhAn(int idBenhAn, int idBenhNhan, String maBenhAn) {
        this.idBenhAn = idBenhAn;
        this.idBenhNhan = idBenhNhan;
        this.maBenhAn = maBenhAn;
    }

    public int getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(int idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public int getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(int idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }
}
