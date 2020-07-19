package service;

import java.sql.SQLException;
import java.util.List;

import bean.Patient;
import dao.PatientDao;

public class PatientService {
    /**
     * 获取patient，若查询结果为空则返回null
     */
    public static Patient findByRecordID(int recordID) throws SQLException, ClassNotFoundException {
        PatientDao patiDao = new PatientDao();

        List<Patient> patiList = patiDao.findByRecordID(recordID);
        Patient patient;

        if (patiList.isEmpty())
            patient = null;
        else
            patient = patiList.get(0);

        patiDao.close();
        return patient;
    }

    /**
     * 向表中插入patient，不使用patient.id
     */
    public static void insert(Patient patient) throws SQLException, ClassNotFoundException {
        PatientDao patiDao = new PatientDao();
        patiDao.insert(patient);
        patiDao.close();
    }
}