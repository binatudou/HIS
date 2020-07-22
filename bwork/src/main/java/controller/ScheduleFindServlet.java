package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.Schedule;
import service.ScheduleService;

@WebServlet(name = "ScheduleFindServlet", urlPatterns = { "/scheFind" })
public class ScheduleFindServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 获取排班id对应医生排班信息
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));

            Schedule schedule = ScheduleService.find(scheduleID);

            Map<String, Object> scheOption = new HashMap<>();

            if (schedule != null) {
                scheOption.put("scheduleID", scheduleID);
                scheOption.put("doctorID", schedule.getDoctorID());
                scheOption.put("departmentID", schedule.getDepartmentID());
                scheOption.put("docName", schedule.getDocName());
                scheOption.put("docLevel", schedule.getDocLevel());
                scheOption.put("workDate", schedule.getWorkDate());
                scheOption.put("workTime", schedule.getWorkTime());
                scheOption.put("totalNumber", schedule.getTotalNumber());
                scheOption.put("usedNumber", schedule.getUsedNumber());
            }

            String resultJson = JSON.toJSONString(scheOption);

            PrintWriter writer = response.getWriter();
            writer.write(resultJson);
            writer.flush();
            writer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}