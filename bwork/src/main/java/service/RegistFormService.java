package service;

import java.sql.SQLException;
import java.util.List;

import bean.RegistForm;
import dao.RegistFormDao;

public class RegistFormService {
  public static List<RegistForm> find(int id) throws SQLException, ClassNotFoundException {
    RegistFormDao registDao = new RegistFormDao();
    List<RegistForm> rFormList = registDao.findByRecordID(id);
    registDao.close();
    return rFormList;
  }
}