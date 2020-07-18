package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 解决中文乱码
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/javascript;charset=utf-8");

            //test
            System.out.println(request.getParameter("registDate"));
            System.out.println(request.getParameter("department"));
            System.out.println(request.getParameter("docTime"));
            System.out.println(request.getParameter("docLevel"));
            //test

            Date registDate = Date.valueOf(request.getParameter("registDate"));
            int departmentID = Integer.parseInt(request.getParameter("department"));
            int docTime = Integer.parseInt(request.getParameter("docTime"));
            int docLevel = Integer.parseInt(request.getParameter("docLevel"));

            List<Schedule> scheList = ScheduleService.searchSchedule(registDate, departmentID, docTime, docLevel);

            List<Map<String, Object>> scheOptionList = new ArrayList<>();

            for (Schedule schedule : scheList) {
                Map<String, Object> scheOption = new HashMap<>();

                scheOption.put("scheduleID", schedule.getId());
                scheOption.put("docName", schedule.getDocName());

                scheOptionList.add(scheOption);
            }

            String resultJson = JSON.toJSONString(scheOptionList);

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