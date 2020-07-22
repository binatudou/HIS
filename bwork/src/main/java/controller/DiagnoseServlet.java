package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.Diagnosis;
import service.DiagnosisService;

@WebServlet(name = "DiagnoseServlet", urlPatterns = { "/diagnose" })
public class DiagnoseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 医生对患者进行完诊，并保存诊断信息
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String docIDStr = String.valueOf(request.getSession().getAttribute("doctorID"));
            Map<String, Object> resultMap = new HashMap<>();
            if (docIDStr == null) {
                resultMap.put("result", -1);
            } else {
                int registID = Integer.parseInt(request.getParameter("registID"));
                int doctorID = Integer.parseInt(docIDStr);
                int diseaseID = Integer.parseInt(request.getParameter("diseaseID"));
                String diseName = request.getParameter("diseName");
                String diagInfo = request.getParameter("diagInfo");

                Diagnosis diag = new Diagnosis(0, registID, doctorID, diseaseID, diseName, diagInfo);
                int resultCode = DiagnosisService.diagnose(diag);

                resultMap.put("resultCode", resultCode);

                String result = JSON.toJSONString(resultMap);

                PrintWriter writer = response.getWriter();
                writer.write(result);
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}