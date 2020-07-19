package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import bean.Drugs;
import service.DrugService;

@WebServlet(name = "DrugFindAllServlet", urlPatterns = { "/drugFindAll" })
public class DrugFindAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Map<String, Object>> drugsList = new ArrayList<>();

            //获取表中全部数据
            List<Drugs> dList = DrugService.drugFindAll();
            for (Drugs drug : dList) {
                Map<String, Object> drugMap = new HashMap<>();

                drugMap.put("drugID", drug.getId());
                drugMap.put("drugsCode", drug.getDrugsCode());
                drugMap.put("drugsName", drug.getDrugsName());
                drugMap.put("drugsFormat", drug.getDrugsFormat());
                drugMap.put("drugsPrice", drug.getDrugsPrice());
                drugMap.put("mnemonicCode", drug.getMnemonicCode());

                drugsList.add(drugMap);
            }

            String drugOptionJson = JSON.toJSONString(drugsList);

            PrintWriter writer = response.getWriter();
            writer.write(drugOptionJson);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}