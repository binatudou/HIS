package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        // TODO
        try {
            request.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(request.getParameter("id"));
            List<RegistForm> rFormList = RegistFormService.find(id);
            List<RefundItem> rItemList = new ArrayList<>();

            for (RegistForm rForm : rFormList) {
                rItemList.add(new RefundItem(rForm.getId(), id, rForm.getPatiName(), rForm.getReseDate(),
                        DOC_DATE[rForm.getDocTime()], rForm.getDeptName(), STATUS[rForm.getDiagStatus()]));
            }

            request.getRequestDispatcher("").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(request.getParameter("id"));
            List<RegistForm> rFormList = RegistFormService.find(id);
            List<RefundItem> rItemList = new ArrayList<>();

            for (RegistForm rForm : rFormList) {
                rItemList.add(new RefundItem(rForm.getId(), id, rForm.getPatiName(), rForm.getReseDate(),
                        DOC_DATE[rForm.getDocTime()], rForm.getDeptName(), STATUS[rForm.getDiagStatus()]));
            }
            String rItemJson = JSON.toJSONString(rItemList);

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

    public class RefundItem {
        int registID;
        int recordID;
        String patiName;
        Date reseDate;
        String docTime;
        String deptName;
        String diagStatus;

        public RefundItem(int registID, int recordID, String patiName, Date reseDate, String docTime, String deptName,
                String diagStatus) {
            this.registID = registID;
            this.recordID = recordID;
            this.patiName = patiName;
            this.reseDate = reseDate;
            this.docTime = docTime;
            this.deptName = deptName;
            this.diagStatus = diagStatus;
        }
    }
}