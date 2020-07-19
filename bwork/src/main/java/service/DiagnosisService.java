package service;

import java.sql.SQLException;

import bean.Diagnosis;
import dao.DiagnosisDao;

public class DiagnosisService {
    public static int diagnose(Diagnosis diagnosis) throws SQLException, ClassNotFoundException {
        DiagnosisDao dDao = new DiagnosisDao();

        dDao.insert(diagnosis);
        int result = RegistFormService.diagnose(diagnosis.getRegistID());

        dDao.close();
        return result;
    }
}