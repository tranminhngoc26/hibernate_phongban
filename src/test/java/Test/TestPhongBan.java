package Test;

import Dao.PhongBanDao;
import DaoImpl.PhongBanDaoImpl;
import Entity.PhongBan;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

public class TestPhongBan {

  @Test
  public void checkFindAll() {
    PhongBanDao phongBanDao = new PhongBanDaoImpl();
    List<PhongBan> list = phongBanDao.findAll();
  }


  @Test
  public void checkUpdatePhongBan() {
    PhongBanDao phongBanDao = new PhongBanDaoImpl();
    PhongBan phongBan = new PhongBan();
    phongBan.setMapb(1);
    phongBan.setTenpb("Giao Vu");
    phongBanDao.update(phongBan);
  }

  @Test
  public void checkSavePhongBan(){
    PhongBanDao phongBanDao = new PhongBanDaoImpl();
    PhongBan phongBan = new PhongBan();
    phongBan.setMapb(3);
    phongBan.setTenpb("Kinh Doanh");
    phongBanDao.update(phongBan);
  }

  @Test
  public  void checkFindbyId(){
    PhongBanDao phongBanDao = new PhongBanDaoImpl();
    PhongBan phongBan = phongBanDao.findById(1);
  }

  @Test
  public void checkTestDelete(){
    List<Integer> listId = new ArrayList<Integer>();
    listId.add(1);
    listId.add(2);
    listId.add(3);
    PhongBanDao phongBanDao = new PhongBanDaoImpl();
    Integer count = phongBanDao.delete(listId);
  }
}