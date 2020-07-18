package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import bean.RegistForm;

public class RegistFormDao extends Dao<RegistForm> {
    private static final String TABLE_NAME = "regist_form";

    public RegistFormDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public List<RegistForm> findByRecordID(int recordID) throws SQLException {
        return find(TABLE_NAME, "RecordID", Integer.toString(recordID));
    }

    // 执行退号，若对应记录为已看诊则直接返回
    public int refund(int id) throws SQLException {
        RegistForm rForm = find(TABLE_NAME, "id", Integer.toString(id)).get(0);
        if (rForm.getDiagStatus() == 0) {
            String sql = "update " + TABLE_NAME + " set DiagStatus = 2 where id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }
        return rForm.getDiagStatus();
    }

    @Override
    protected RegistForm RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int recordID = rs.getInt("RecordID");
        int departmentID = rs.getInt("DepartmentID");
        int doctorID = rs.getInt("DoctorID");
        int operatorID = rs.getInt("OperatorID");
        String patiName = rs.getString("PatiName");
        int age = rs.getInt("Age");
        Date registTime = rs.getDate("RegistTime");
        String deptName = rs.getString("DeptName");
        Date reseDate = rs.getDate("ReseDate");
        int docTime = rs.getInt("DocTime");
        int diagStatus = rs.getInt("DiagStatus");

        RegistForm rForm = new RegistForm(id, recordID, departmentID, doctorID, operatorID, patiName, age, registTime,
                deptName, reseDate, docTime, diagStatus);

        return rForm;
    }
}