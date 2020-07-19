package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
        List<RegistForm> rFormList = find(TABLE_NAME, "id", Integer.toString(id));
        if (rFormList.isEmpty())
            return -1;
        if (rFormList.get(0).getDiagStatus() == 0) {
            String sql = "update " + TABLE_NAME + " set DiagStatus = 2 where id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }
        return rFormList.get(0).getDiagStatus();
    }

    public void insert(RegistForm rForm) throws SQLException {
        String sql = "insert into " + TABLE_NAME
                + "(id, RecordID, DepartmentID, ScheduleID, OperatorID, PatiName, Age, RegistTime, DeptName, ReseDate, DocTime, DiagStatus)"
                + " values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        AssemblePS(preparedStatement, rForm);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    protected RegistForm RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int recordID = rs.getInt("RecordID");
        int departmentID = rs.getInt("DepartmentID");
        int scheduleID = rs.getInt("ScheduleID");
        int operatorID = rs.getInt("OperatorID");
        String patiName = rs.getString("PatiName");
        int age = rs.getInt("Age");
        Timestamp registTime = rs.getTimestamp("RegistTime");
        String deptName = rs.getString("DeptName");
        Date reseDate = rs.getDate("ReseDate");
        int docTime = rs.getInt("DocTime");
        int diagStatus = rs.getInt("DiagStatus");

        RegistForm rForm = new RegistForm(id, recordID, departmentID, scheduleID, operatorID, patiName, age, registTime,
                deptName, reseDate, docTime, diagStatus);

        return rForm;
    }

    private void AssemblePS(PreparedStatement preparedStatement, RegistForm registForm) throws SQLException {
        preparedStatement.setInt(1, registForm.getRecordID());
        preparedStatement.setInt(2, registForm.getDepartmentID());
        preparedStatement.setInt(3, registForm.getScheduleID());
        preparedStatement.setInt(4, registForm.getOperatorID());
        preparedStatement.setString(5, registForm.getPatiName());
        preparedStatement.setInt(6, registForm.getAge());
        preparedStatement.setTimestamp(7, registForm.getRegistTime());
        preparedStatement.setString(8, registForm.getDeptName());
        preparedStatement.setDate(9, registForm.getReseDate());
        preparedStatement.setInt(10, registForm.getDocTime());
        preparedStatement.setInt(11, registForm.getDiagStatus());
    }
}