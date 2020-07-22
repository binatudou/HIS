package service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import bean.PresItem;
import bean.Prescription;
import dao.PrescriptionDao;

public class PrescriptionService {
    public static List<Prescription> findById(int id) throws SQLException, ClassNotFoundException {
        PrescriptionDao presDao = new PrescriptionDao();
        List<Prescription> rFormList = presDao.findById(id);
        presDao.close();
        return rFormList;
    }

    public static List<Prescription> findByRecordID(int recordID) throws SQLException, ClassNotFoundException {
        PrescriptionDao presDao = new PrescriptionDao();
        List<Prescription> presList = presDao.findByRecordID(recordID);
        presDao.close();
        return presList;
    }

    public static void add(Map<String, String[]> formMap, String docStr) throws ClassNotFoundException, SQLException {
        int registID = Integer.parseInt(formMap.get("registID")[0]);
        int recordID = RegistFormService.findById(registID).getRecordID();
        int doctorID = Integer.parseInt(docStr);
        String patiName = formMap.get("patiName")[0];
        String presName = formMap.get("presName")[0];
        Timestamp creationTime = new Timestamp(new java.util.Date().getTime());
        double totalPrice = Double.parseDouble(formMap.get("totalPrice")[0]);

        Prescription prescription = new Prescription(0, registID, recordID, doctorID, patiName, presName, creationTime,
                totalPrice, 0);

        // 开立处方，置状态为0
        int prescriptionID = presCreate(prescription);
        // 录入药品记录
        int len = Integer.parseInt(formMap.get("itemLength")[0]);
        for (int i = 0; i < len; i++) {
            int drugID = Integer.parseInt(formMap.get("items[" + i + "][drugID]")[0]);
            String drugName = formMap.get("items[" + i + "][drugName]")[0];
            String description = formMap.get("items[" + i + "][description]")[0];
            Double drugPrice = Double.parseDouble(formMap.get("items[" + i + "][drugPrice]")[0]);
            int drugNumber = Integer.parseInt(formMap.get("items[" + i + "][drugNumber]")[0]);

            PresItem pItem = new PresItem(0, prescriptionID, drugID, drugName, drugPrice, drugNumber, description, 0);
            PresItemService.addDrug(pItem);
        }

        presEndCreate(prescriptionID);
    }

    /**
     * 返回生成处方的ID
     * 
     * @param prescription
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static int presCreate(Prescription prescription) throws SQLException, ClassNotFoundException {
        PrescriptionDao presDao = new PrescriptionDao();
        int prescriptionID = presDao.create(prescription);
        presDao.close();
        return prescriptionID;
    }

    /**
     * 返回生成处方的结果
     * 
     * @param prescriptionID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static int presEndCreate(int prescriptionID) throws SQLException, ClassNotFoundException {
        PrescriptionDao presDao = new PrescriptionDao();
        int result = presDao.presEndCreate(prescriptionID);
        presDao.close();
        return result;
    }

    /**
     * 执行缴费，返回执行前处方的缴费情况
     *
     * @param id
     * @return -1: 查询处方时出错 0:处方未开立 1: 缴费成功 2: 处方已缴费 3: 处方已退费 n:处方明细第n - 3项缴费出错
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static int presPay(int id) throws SQLException, ClassNotFoundException {
        PrescriptionDao presDao = new PrescriptionDao();
        int result = PresItemService.payDrugs(id);
        if(result == 0){
            result = presDao.presPay(id);
        }else{
            result += 4;
        }
        presDao.close();
        return result;
    }
}