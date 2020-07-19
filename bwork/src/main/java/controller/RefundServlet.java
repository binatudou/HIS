package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import bean.RegistForm;
import service.RegistFormService;

@WebServlet(name = "RefundServlet", urlPatterns = { "/refund" })
public class RefundServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String STATUS[] = { "未诊", "已诊", "已退号" };
    private static final String DOC_DATE[] = { "上午", "下午", "晚间" };

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            int registID = Integer.parseInt(request.getParameter("RegistID"));

            int result = RegistFormService.refund(registID);
            
            PrintWriter writer = response.getWriter();
            writer.write(String.valueOf(result));
            writer.flush();
            writer.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Map<String, Object>> rItemList = new ArrayList<>();

            int recordID = Integer.parseInt(request.getParameter("RecordID"));
            List<RegistForm> rFormList = RegistFormService.findByRecordID(recordID);

            for (RegistForm rForm : rFormList) {
                Map<String, Object> rItem = new HashMap<>();
                rItem.put("RegistID", rForm.getId());
                rItem.put("RecordID", recordID);
                rItem.put("PatiName", rForm.getPatiName());
                rItem.put("ReseDate", rForm.getReseDate());
                rItem.put("DocTime", DOC_DATE[rForm.getDocTime()]);
                rItem.put("DeptName", rForm.getDeptName());
                rItem.put("DiagStatus", STATUS[rForm.getDiagStatus()]);

                rItemList.add(rItem);
            }
            String rItemJson = JSON.toJSONString(rItemList);
            System.out.println(rItemJson);

            PrintWriter writer = response.getWriter();
            writer.write(rItemJson);
            writer.flush();
            writer.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}