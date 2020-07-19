package service;

import java.sql.SQLException;
import java.util.List;

import bean.PresItem;
import dao.PresItemDao;

public class PresItemService {
  public static int giveDrugs(int prescriptionID) throws ClassNotFoundException, SQLException {
    PresItemDao piDao = new PresItemDao();
    int resultCode = piDao.giveDrugs(prescriptionID);
    piDao.close();
    return resultCode;
  }

  public static int payDrugs(int prescriptionID) throws SQLException, ClassNotFoundException {
    PresItemDao piDao = new PresItemDao();
    int resultCode = piDao.payDrugs(prescriptionID);
    piDao.close();
    return resultCode;
  }

  public static List<PresItem> getDrugs(int prescriptionID) throws SQLException, ClassNotFoundException {
    PresItemDao piDao = new PresItemDao();
    List<PresItem> drugs = piDao.findByPrescriptionID(prescriptionID);
    piDao.close();
    return drugs;
  }

  public static void addDrug(PresItem pItem) throws SQLException, ClassNotFoundException {
    PresItemDao piDao = new PresItemDao();
    piDao.insert(pItem);
    piDao.close();
  }
}