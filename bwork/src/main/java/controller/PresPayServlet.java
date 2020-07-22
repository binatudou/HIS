package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.Prescription;
import service.PrescriptionService;

@WebServlet(name = "PresPayServlet", urlPatterns = { "/presPay" })
public class PresPayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String STATUS[] = { "尚未开立", "已开立", "已缴费", "已退号" };

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Map<String, Object> resultMap = new HashMap<>();
            int prescriptionID = Integer.parseInt(request.getParameter("prescriptionID"));

            PrescriptionService.presPay(prescriptionID);

            resultMap.put("success", true);

            String result = JSON.toJSONString(resultMap);

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
            List<Prescription> prescriptionList = PrescriptionService.findByRecordID(recordID);

            for (Prescription prescription : prescriptionList) {
                //仅发送未缴费的处方
                if (prescription.getPresStatus() == 1) {
                    Map<String, Object> pItem = new HashMap<>();
                    pItem.put("prescriptionID", prescription.getId());
                    pItem.put("recordID", recordID);
                    pItem.put("patiName", prescription.getPatiName());
                    pItem.put("presName", prescription.getPresName());
                    pItem.put("totalPrice", prescription.getTotalPrice());
                    //转换日期为字符串格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date tempDate = new Date(prescription.getCreationTime().getTime());
                    String creationTimeStr = sdf.format(tempDate);
                    pItem.put("creationTime", creationTimeStr);
                    
                    pItem.put("presStatus", STATUS[prescription.getPresStatus()]);

                    rItemList.add(pItem);
                }
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
}