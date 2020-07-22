package service;

import java.sql.SQLException;
import java.util.List;

import bean.Patient;
import dao.PatientDao;

public class PatientService {
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

    public static void insert(Patient patient) throws SQLException, ClassNotFoundException {
        PatientDao patiDao = new PatientDao();
        patiDao.insert(patient);
        patiDao.close();
    }
}