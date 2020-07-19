package service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Patient;
import bean.RegistForm;
import dao.RegistFormDao;

public class RegistFormService {
    public static RegistForm findById(int id) throws SQLException, ClassNotFoundException {
        RegistFormDao registDao = new RegistFormDao();
        List<RegistForm> rFormList = registDao.findById(id);
        registDao.close();
        return rFormList.size() == 1? rFormList.get(0): null;
    }

    public static List<RegistForm> findByRecordID(int recordID) throws SQLException, ClassNotFoundException {
        RegistFormDao registDao = new RegistFormDao();
        List<RegistForm> rFormList = registDao.findByRecordID(recordID);
        registDao.close();
        return rFormList;
    }

    public static List<RegistForm> findByScheduleID(int scheduleID) throws SQLException, ClassNotFoundException {
        RegistFormDao registDao = new RegistFormDao();
        List<RegistForm> rFormList = registDao.findByScheduleID(scheduleID);
        registDao.close();
        return rFormList;
    }

    public static Map<String, Object> docFindPati(int scheduleID) throws ClassNotFoundException, SQLException {
        // 获取数据
        List<RegistForm> rFormList = findByScheduleID(scheduleID);
        // 进行分类
        Map<String, Object> rFormMap = new HashMap<>();
        List<Map<String, Object>> undiagList = new ArrayList<>();
        List<Map<String, Object>> diagList = new ArrayList<>();
        for (RegistForm rForm : rFormList) {
            if (rForm.getDiagStatus() == 0) {
                Map<String, Object> rMap = new HashMap<>();
                rMap.put("patiName", rForm.getPatiName());
                rMap.put("registID", rForm.getId());
                undiagList.add(rMap);
            } else if (rForm.getDiagStatus() == 1) {
                Map<String, Object> rMap = new HashMap<>();
                rMap.put("patiName", rForm.getPatiName());
                rMap.put("registID", rForm.getId());
                diagList.add(rMap);
            }
        }
        rFormMap.put("undiagList", undiagList);
        rFormMap.put("diagList", diagList);

        return rFormMap;
    }

    public static void regist(Map<String, String[]> formMap, String operStr)
            throws ClassNotFoundException, SQLException {
        RegistFormDao rFormDao = new RegistFormDao();

        int recordID = Integer.parseInt(formMap.get("recordID")[0]);
        int departmentID = Integer.parseInt(formMap.get("department")[0]);
        int scheduleID = Integer.parseInt(formMap.get("doctorSchedule")[0]);
        int operatorID = Integer.parseInt(operStr);
        String patiName = formMap.get("patiName")[0];
        int age = Integer.parseInt(formMap.get("age")[0]);
        Timestamp registTime = new Timestamp(new java.util.Date().getTime());
        String deptName = DepartmentService.deptFind(departmentID).getDeptName();
        Date reseDate = Date.valueOf(formMap.get("registDate")[0]);
        int docTime = Integer.parseInt(formMap.get("docTime")[0]);

        RegistForm rForm = new RegistForm(0, recordID, departmentID, scheduleID, operatorID, patiName, age, registTime,
                deptName, reseDate, docTime, 0);

        if (PatientService.findByRecordID(recordID) == null) {
            int sex = Integer.parseInt(formMap.get("sex")[0]);
            Date birthday = Date.valueOf(formMap.get("birthday")[0]);
            String idNumber = formMap.get("idNumber")[0];
            String patiAddress = formMap.get("patiAddress")[0];

            Patient patient = new Patient(0, recordID, patiName, sex, birthday, idNumber, patiAddress);
            PatientService.insert(patient);
        }

        rFormDao.insert(rForm);
        rFormDao.close();
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
        RegistFormDao rFormDao = new RegistFormDao();
        int result = rFormDao.refund(id);
        rFormDao.close();
        return result;
    }

    /**
     * 执行完诊，返回执行前挂号单的挂号状态
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static int diagnose(int id) throws SQLException, ClassNotFoundException {
        RegistFormDao rFormDao = new RegistFormDao();
        int result = rFormDao.diagnose(id);
        rFormDao.close();
        return result;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        RegistFormService.docFindPati(1);
    }
}