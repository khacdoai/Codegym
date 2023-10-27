package case_study.model;

public class Employee {
   private String manhanvien;
   private String hoten;
   private String ngaysinh;
   private String gioitinh;
   private String CMND;
   private String sdt;
   private String email;
   private String trinhdo;
   private String vitri;
   private int luong;

   public Employee() {
   }

   public Employee(String manhanvien, String hoten, String ngaysinh, String gioitinh, String CMND, String sdt, String email, String trinhdo, String vitri, int luong) {
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

   public String getManhanvien() {
      return manhanvien;
   }

   public void setManhanvien(String manhanvien) {
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

   public String getCMND() {
      return CMND;
   }

   public void setCMND(String CMND) {
      this.CMND = CMND;
   }

   public String getSdt() {
      return sdt;
   }

   public void setSdt(String sdt) {
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

   public int getLuong() {
      return luong;
   }

   public void setLuong(int luong) {
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


