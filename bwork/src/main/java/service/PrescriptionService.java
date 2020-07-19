package service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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

    public static void add(Map<String, String[]> formMap, String docStr)
            throws ClassNotFoundException, SQLException {
        int registID = Integer.parseInt(formMap.get("registID")[0]);
        int recordID = RegistFormService.findById(registID).getRecordID();
        int doctorID = Integer.parseInt(docStr);
        String patiName = formMap.get("patiName")[0];
        String presName = formMap.get("presName")[0];
        Timestamp creationTime = new Timestamp(new java.util.Date().getTime());
        double totalPrice = Double.parseDouble(formMap.get("totalPrice")[0]);

        Prescription prescription = new Prescription(0, registID, recordID, doctorID, patiName, presName, creationTime, totalPrice, 0, null);

        //开立处方，置状态为0
        int prescriptionID = presCreate(prescription);
        //录入药品记录
        for (String itemStr : formMap.get("items")) {
            JSONObject jItem = JSON.parseObject(itemStr);
            int drugID = Integer.parseInt(jItem.getString("drugID"));
            String drugName = jItem.getString("drugName");
            String description = jItem.getString("description");
            Double drugPrice = Double.parseDouble(jItem.getString("drugPrice"));
            int drugNumber = Integer.parseInt(jItem.getString("drugNumber"));
            
            PresItem pItem = new PresItem(0, prescriptionID, drugID, drugName, drugPrice, drugNumber, description, 0);
            PresItemService.addDrug(pItem);
        }

        presEndCreate(prescriptionID);
    }

    /**
     * 返回生成处方的ID
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


    public static int presEndCreate(int prescriptionID) throws SQLException, ClassNotFoundException {
        PrescriptionDao presDao = new PrescriptionDao();
        presDao.endCreate(prescriptionID);
        presDao.close();
        return prescriptionID;
    }

    /**
     * 执行退号，返回执行前挂号单的挂号状态
     * 
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static int refund(int id) throws SQLException, ClassNotFoundException {
        PrescriptionDao presDao = new PrescriptionDao();
        int result = presDao.refund(id);
        presDao.close();
        return result;
    }
}