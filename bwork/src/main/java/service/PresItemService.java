package service;

import java.sql.SQLException;
import java.util.List;

import bean.PresItem;
import dao.PresItemDao;

public class PresItemService {
    /**
     * 处方明细发药
     * 
     * @param pIDList 待发药的处方明细id列表
     * @return index 0: 发药成功 n: 第n个药品发药错误(从1起数)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int giveDrugs(List<Integer> pIDList) throws ClassNotFoundException, SQLException {
        PresItemDao piDao = new PresItemDao();

        for (int i = 0; i < pIDList.size(); i++) {
            int presItemID = pIDList.get(i);
            if (piDao.giveDrug(presItemID) != 1) {
                piDao.close();
                return i + 1;
            }
        }

        piDao.close();
        return 0;
    }

    /**
     * 处方明细缴费
     * 
     * @param prescriptionID 待缴费的处方id
     * @return -1: 未查到处方或药品记录; 0: 缴费成功; n: 第n个药品缴费错误(从1起数)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int payDrugs(int prescriptionID) throws SQLException, ClassNotFoundException {
        PresItemDao piDao = new PresItemDao();
        int resultCode = piDao.payDrugs(prescriptionID);
        piDao.close();
        return resultCode;
    }

    /**
     * 搜寻处方下的药品
     * 
     * @param prescriptionID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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