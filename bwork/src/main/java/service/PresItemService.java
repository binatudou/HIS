package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.PresItem;
import dao.PresItemDao;

public class PresItemService {
  /**
   * 
   * @param pIDList 待开药的处方明细id
   * @return index 0: 发药成功 n: 第n个药品发药错误(从1起数)
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public static int giveDrugs(List<Integer> pIDList) throws ClassNotFoundException, SQLException {
    PresItemDao piDao = new PresItemDao();

    for (int i = 0; i < pIDList.size(); i++) {
      int presItemID = pIDList.get(i);
      if(piDao.giveDrug(presItemID) != 1){
        piDao.close();
        return presItemID + 1;
      }
    }

    piDao.close();
    return 0;
  }

  public static int payDrugs(int prescriptionID) throws SQLException, ClassNotFoundException {
    PresItemDao piDao = new PresItemDao();
    int resultCode = piDao.payDrugs(prescriptionID);
    piDao.close();
    return resultCode;
  }

  public static int payDrug(int presItemID) throws SQLException, ClassNotFoundException {
    PresItemDao piDao = new PresItemDao();
    int resultCode = piDao.giveDrug(presItemID);
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

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    List<Integer> pIDList = new ArrayList<>();
    pIDList.add(1);
    pIDList.add(2);
    giveDrugs(pIDList);
  }
}