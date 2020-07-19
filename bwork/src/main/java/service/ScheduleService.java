package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import bean.Schedule;
import dao.ScheduleDao;

public class ScheduleService {
    public static List<Schedule> searchSchedule(Date registDate, int departmentID, int docTime, int docLevel)
            throws SQLException, ClassNotFoundException {
        ScheduleDao scheDao = new ScheduleDao();
        List<Schedule> scheList = scheDao.searchSchedule(registDate, departmentID, docTime, docLevel);
        scheDao.close();
        return scheList;
    }

    public static Schedule find(int scheduleID)
            throws SQLException, ClassNotFoundException {
        ScheduleDao scheDao = new ScheduleDao();
        Schedule schedule = scheDao.find(scheduleID);
        scheDao.close();
        return schedule;
    }
}
