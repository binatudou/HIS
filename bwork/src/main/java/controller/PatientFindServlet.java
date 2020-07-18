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

import bean.Patient;
import service.PatientService;

@WebServlet(name = "PatientFindServlet", urlPatterns = { "/patiFind" })
public class PatientFindServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            int recordID = Integer.parseInt(request.getParameter("recordID"));
            Patient patient = PatientService.findByRecordID(recordID);
            request.setAttribute("patient", patient);

            Map<String, Object> result = new HashMap<>();

            String resultJson = JSON.toJSONString(result);

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