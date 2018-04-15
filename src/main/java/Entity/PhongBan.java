package Entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phongban")
public class PhongBan{
   @Id
  @Column(name = "mapb")
  private Integer mapb;
   @Column(name = "tenpb")
  private String tenpb;
   @OneToMany(mappedBy = "phongBan" , fetch = FetchType.LAZY)
   private List<NhanVien> listNhanVien;

  public Integer getMapb() {
    return mapb;
  }

  public void setMapb(Integer mapb) {
    this.mapb = mapb;
  }

  public String getTenpb() {
    return tenpb;
  }

  public void setTenpb(String tenpb) {
    this.tenpb = tenpb;
  }
}