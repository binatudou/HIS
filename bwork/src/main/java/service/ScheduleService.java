package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import bean.Schedule;
import dao.ScheduleDao;

public class ScheduleService {
    /**
     * 搜寻特定日期、科室、午别、号别的医生排班
     * @param registDate
     * @param departmentID
     * @param docTime
     * @param docLevel
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Schedule> searchSchedule(Date registDate, int departmentID, int docTime, int docLevel)
            throws SQLException, ClassNotFoundException {
        ScheduleDao scheDao = new ScheduleDao();
        List<Schedule> scheList = scheDao.searchSchedule(registDate, departmentID, docTime, docLevel);
        scheDao.close();
        return scheList;
    }

    /**
     * 根据排班id获取排班
     * @param scheduleID
     * @return schedule
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Schedule find(int scheduleID)
            throws SQLException, ClassNotFoundException {
        ScheduleDao scheDao = new ScheduleDao();
        Schedule schedule = scheDao.find(scheduleID);
        scheDao.close();
        return schedule;
    }

    /**
     * 使id对应排班记录已用号数+1
     * @param scheduleID
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static boolean regist(int scheduleID) throws SQLException, ClassNotFoundException {
        ScheduleDao scheDao = new ScheduleDao();
        boolean result = scheDao.regist(scheduleID);
        scheDao.close();
        return result;
    }
}
