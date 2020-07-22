package service;

import java.sql.SQLException;
import java.util.List;

import bean.LevelPrice;
import dao.LevelPriceDao;

public class LevelPriceService {
    /**
     * 获取号费表
     * 
     * @return 号费list
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<LevelPrice> lPriceFindAll() throws SQLException, ClassNotFoundException {
        LevelPriceDao lPriceDao = new LevelPriceDao();
        List<LevelPrice> lPriceList = lPriceDao.lPriceFindAll();
        lPriceDao.close();
        return lPriceList;
    }
}