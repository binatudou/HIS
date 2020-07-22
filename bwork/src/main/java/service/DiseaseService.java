package service;

import java.sql.SQLException;
import java.util.List;

import bean.Disease;
import dao.DiseaseDao;

public class DiseaseService {
  /**
   * 获取疾病表
   * 
   * @return 疾病
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public static List<Disease> diseFindAll() throws SQLException, ClassNotFoundException {
    DiseaseDao diseDao = new DiseaseDao();
    List<Disease> diseList = diseDao.diseFindAll();
    diseDao.close();
    return diseList;
  }
}