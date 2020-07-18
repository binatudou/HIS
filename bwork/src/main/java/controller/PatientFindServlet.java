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
            // 解决中文乱码
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/javascript;charset=utf-8");

            int recordID = Integer.parseInt(request.getParameter("recordID"));
            Patient patient = PatientService.findByRecordID(recordID);

            Map<String, Object> result = new HashMap<>();
            if (patient != null) {
                result.put("recordExist", true);
                result.put("patiName", patient.getPatiName());
                result.put("sex", patient.getSex());
                result.put("birthday", patient.getBirthday());
                result.put("idNumber", patient.getIdNumber());
                result.put("patiAddress", patient.getPatiAddress());
            }
            else{
                result.put("recordExist", false);
            }

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

    // public static void main(String[] args) {
    //     try {
    //         int recordID = 5123;
    //         Patient patient = PatientService.findByRecordID(recordID);

    //         Map<String, Object> result = new HashMap<>();
    //         if (patient != null) {
    //             result.put("recordExist", true);
    //             result.put("patiName", patient.getPatiName());
    //             result.put("sex", patient.getSex());
    //             result.put("birthday", patient.getBirthday());
    //             result.put("idNumber", patient.getIdNumber());
    //             result.put("patiAddress", patient.getPatiAddress());
    //         }
    //         else{
    //             result.put("recordExist", false);
    //         }

    //         String resultJson = JSON.toJSONString(result);
    //         System.out.println(resultJson);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     } catch (ClassNotFoundException e) {
    //         e.printStackTrace();
    //     }
    // }
}