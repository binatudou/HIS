package service;

import java.sql.SQLException;
import java.util.List;

import bean.Drug;
import dao.DrugDao;

public class DrugService {
  public static List<Drug> drugFindAll() throws SQLException, ClassNotFoundException {
    DrugDao drugDao = new DrugDao();
    List<Drug> drugList = drugDao.drugFindAll();
    drugDao.close();
    return drugList;
  }
}