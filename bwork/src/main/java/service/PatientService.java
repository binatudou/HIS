package service;

import java.sql.SQLException;

import bean.Patient;
import dao.PatientDao;

public class PatientService {
    public static Patient findByRecordID(int recordID) throws SQLException, ClassNotFoundException {
        PatientDao patiDao = new PatientDao();
        Patient patient = patiDao.findByRecordID(recordID);
        patiDao.close();
        return patient;
    }
}
