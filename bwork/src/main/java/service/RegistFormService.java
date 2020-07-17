package service;

import java.sql.SQLException;
import java.util.List;

import bean.RegistForm;
import dao.RegistFormDao;

public class RegistFormService {
  public static List<RegistForm> findByRecordID(int recordID) throws SQLException, ClassNotFoundException {
    RegistFormDao registDao = new RegistFormDao();
    List<RegistForm> rFormList = registDao.findByRecordID(recordID);
    registDao.close();
    return rFormList;
  }

  public static int refund(int id) throws SQLException, ClassNotFoundException {
    RegistFormDao registDao = new RegistFormDao();
    int result = registDao.refund(id);
    registDao.close();
    return result;
  }
}