package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Schedule;

public class ScheduleDao extends Dao<Schedule> {
    private static final String TABLE_NAME = "schedule";

    public ScheduleDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public List<Schedule> searchSchedule(Date workDate, int departmentID, int docTime, int docLevel)
            throws SQLException {
        Statement statement = connection.createStatement();
        String queryString = "select * from " + TABLE_NAME + " where WorkDate = " + workDate.toString()
                + " and DepartmentID = " + departmentID + " and DocTime = " + docTime + " and DocLevel = " + docLevel;

        //test
        System.out.println(queryString);
        //test
        ResultSet rs = statement.executeQuery(queryString);
        List<Schedule> list = new ArrayList<>();
        while (rs.next()) {
            list.add(RSToBean(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    protected Schedule RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int doctorID = rs.getInt("DoctorID");
        int departmentID = rs.getInt("DepartmentID");
        String docName = rs.getString("DocName");
        int docLevel = rs.getInt("DocLevel");
        Date workDate = rs.getDate("WorkDate");
        int workTime = rs.getInt("WorkTime");
        int totalNumber = rs.getInt("TotalNumber");
        int usedNumber = rs.getInt("UsedNumber");

        Schedule schedule = new Schedule(id, doctorID, departmentID, docName, docLevel, workDate, workTime, totalNumber, usedNumber);

        return schedule;
    }
}