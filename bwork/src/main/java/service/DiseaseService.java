package service;

import java.sql.SQLException;
import java.util.List;

import bean.Disease;
import dao.DiseaseDao;

public class DiseaseService {
  public static List<Disease> diseFindAll() throws SQLException, ClassNotFoundException {
    DiseaseDao diseDao = new DiseaseDao();
    List<Disease> diseList = diseDao.diseFindAll();
    diseDao.close();
    return diseList;
  }
}