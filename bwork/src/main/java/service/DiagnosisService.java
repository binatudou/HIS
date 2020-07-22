package service;

import java.sql.SQLException;

import bean.Diagnosis;
import dao.DiagnosisDao;

public class DiagnosisService {
    /**
     * 进行完诊，并保存诊断信息
     * 
     * @param diagnosis
     * @return 挂号单原挂号状态
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static int diagnose(Diagnosis diagnosis) throws SQLException, ClassNotFoundException {
        DiagnosisDao dDao = new DiagnosisDao();

        dDao.insert(diagnosis);
        int result = RegistFormService.diagnose(diagnosis.getRegistID());

        dDao.close();
        return result;
    }
}