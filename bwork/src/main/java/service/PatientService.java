package service;

import java.sql.SQLException;

import bean.Patient;
import dao.PatientDao;

public class PatientService {
    public static Patient find(int id) throws SQLException, ClassNotFoundException {
        PatientDao patiDao = new PatientDao();
        Patient patient = patiDao.findByRecordID(id);
        patiDao.close();
        return patient;
    }
}
