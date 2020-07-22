package service;

import java.sql.SQLException;
import java.util.List;

import bean.Drug;
import dao.DrugDao;

public class DrugService {
    /**
     * 获取药品信息
     * 
     * @return 药品list
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Drug> drugFindAll() throws SQLException, ClassNotFoundException {
        DrugDao drugDao = new DrugDao();
        List<Drug> drugList = drugDao.drugFindAll();
        drugDao.close();
        return drugList;
    }
}