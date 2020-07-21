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

import bean.PresItem;
import bean.Prescription;
import service.PresItemService;
import service.PrescriptionService;

@WebServlet(name = "DrugGiveServlet", urlPatterns = { "/drugGive" })
public class DrugGiveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String STATUS[] = { "尚未开立", "已开立", "已缴费", "已退号" };
    // TODO

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //获取处方明细id
            Map<String, Object> resultMap = new HashMap<>();
            int len = Integer.parseInt(request.getParameter("IDArrLength"));
            List<Integer> pIDList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                pIDList.add(Integer.parseInt(request.getParameter("prescriptionID[" + i + "]")));
            }

            int resultCode = PresItemService.giveDrugs(pIDList);

            resultMap.put("resultCode", resultCode);

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
            List<Map<String, Object>> ppList = new ArrayList<>();
            //根据病历号寻找已缴费处方
            int recordID = Integer.parseInt(request.getParameter("RecordID"));
            List<Prescription> prescriptionList = PrescriptionService.findByRecordID(recordID);

            for (Prescription prescription : prescriptionList) {
                // 仅发送已缴费的处方
                if (prescription.getPresStatus() == 2) {
                    //prescription + prescription_item
                    Map<String, Object> ppMap = new HashMap<>();
                    int prescriptionID = prescription.getId();
                    List<PresItem> dList = PresItemService.getDrugs(prescriptionID);
                    //排除无效处方
                    if(dList.isEmpty()) continue;
                    //处方明细
                    List<Map<String, Object>> drugs = new ArrayList<>();
                    for (PresItem presItem : dList) {
                        Map<String, Object> drugMap = new HashMap<>();
                        drugMap.put("drugName", presItem.getDrugName());
                        drugMap.put("drugPrice", presItem.getDrugPrice());
                        drugMap.put("drugNumber", presItem.getDrugNumber());
                        drugMap.put("paymentStatus", STATUS[presItem.getPaymentStatus()]);
                        drugs.add(drugMap);
                    }

                    ppMap.put("prescriptionID", prescriptionID);
                    ppMap.put("presName", prescription.getPresName());
                    ppMap.put("recordID", recordID);
                    ppMap.put("patiName", prescription.getPatiName());
                    ppMap.put("totalPrice", prescription.getTotalPrice());
                    //以列表形式保存
                    ppMap.put("drugs", drugs);
                    //将转换后的处方存入返回列表中
                    ppList.add(ppMap);
                }
            }
            String rItemJson = JSON.toJSONString(ppList);

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