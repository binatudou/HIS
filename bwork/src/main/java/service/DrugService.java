package service;

import java.sql.SQLException;
import java.util.List;

import bean.Drugs;
import dao.DrugsDao;

public class DrugService {
  public static List<Drugs> drugFindAll() throws SQLException, ClassNotFoundException {
    DrugsDao drugsDao = new DrugsDao();
    List<Drugs> lPriceList = drugsDao.drugFindAll();
    drugsDao.close();
    return lPriceList;
  }
}