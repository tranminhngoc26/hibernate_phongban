package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer nvid;
    @Column(name = "hoten")
     private String hoten;
    @Column(name = "ngaysinh")
     private String ngaysinh;
    @Column(name = "gioitinh")
     private String gioitinh;
    @Column(name = "diachi")
     private String diachi;

    @ManyToOne
    @JoinColumn(name = "mapb")
    private PhongBan phongBan;
  public Integer getNvid() {
    return nvid;
  }

  public void setNvid(Integer nvid) {
    this.nvid = nvid;
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

  public String getDiachi() {
    return diachi;
  }

  public void setDiachi(String diachi) {
    this.diachi = diachi;
  }

  public PhongBan getPhongBan() {
    return phongBan;
  }

  public void setPhongBan(PhongBan phongBan) {
    this.phongBan = phongBan;
  }
}