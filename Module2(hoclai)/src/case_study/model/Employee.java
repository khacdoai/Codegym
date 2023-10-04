package case_study.model;

public class Employee {
   private int manhanvien;
   private String hoten;
   private String ngaysinh;
   private String gioitinh;
   private int CMND;
   private int sdt;
   private String email;
   private String trinhdo;
   private String vitri;
   private double luong;

   public Employee() {
   }

   public Employee(int manhanvien, String hoten, String ngaysinh, String gioitinh, int CMND, int sdt, String email, String trinhdo, String vitri, double luong) {
      this.manhanvien = manhanvien;
      this.hoten = hoten;
      this.ngaysinh = ngaysinh;
      this.gioitinh = gioitinh;
      this.CMND = CMND;
      this.sdt = sdt;
      this.email = email;
      this.trinhdo = trinhdo;
      this.vitri = vitri;
      this.luong = luong;
   }

   public int getManhanvien() {
      return manhanvien;
   }

   public void setManhanvien(int manhanvien) {
      this.manhanvien = manhanvien;
   }

   public String getHoten() {
      return hoten;
   }

   public void setHoten(String hoten) {
      this.hoten = hoten;
   }

   public String getNgaysinh() {
      return ngaysinh;
   }

   public void setNgaysinh(String ngaysinh) {
      this.ngaysinh = ngaysinh;
   }

   public String getGioitinh() {
      return gioitinh;
   }

   public void setGioitinh(String gioitinh) {
      this.gioitinh = gioitinh;
   }

   public int getCMND() {
      return CMND;
   }

   public void setCMND(int CMND) {
      this.CMND = CMND;
   }

   public int getSdt() {
      return sdt;
   }

   public void setSdt(int sdt) {
      this.sdt = sdt;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getTrinhdo() {
      return trinhdo;
   }

   public void setTrinhdo(String trinhdo) {
      this.trinhdo = trinhdo;
   }

   public String getVitri() {
      return vitri;
   }

   public void setVitri(String vitri) {
      this.vitri = vitri;
   }

   public double getLuong() {
      return luong;
   }

   public void setLuong(double luong) {
      this.luong = luong;
   }


   @Override
   public String toString() {
      return "Employee{" +
              "manhanvien=" + manhanvien +
              ", hoten='" + hoten + '\'' +
              ", ngaysinh='" + ngaysinh + '\'' +
              ", gioitinh='" + gioitinh + '\'' +
              ", CMND=" + CMND +
              ", sdt=" + sdt +
              ", email='" + email + '\'' +
              ", trinhdo='" + trinhdo + '\'' +
              ", vitri='" + vitri + '\'' +
              ", luong=" + luong +
              '}';
   }
   public String GetToCSV() {
      return manhanvien + "," + hoten + "," + ngaysinh + "," + gioitinh + "," + CMND + "," + sdt + "," + email + "," + trinhdo + "," + vitri + "," + luong;
   }

}


