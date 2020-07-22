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

import bean.Disease;
import service.DiseaseService;

@WebServlet(name = "DiseFindAllServlet", urlPatterns = { "/diseFindAll" })
public class DiseFindAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 获取疾病信息
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Map<String, Object>> diseList = new ArrayList<>();

            //获取表中全部数据
            List<Disease> dList = DiseaseService.diseFindAll();
            for (Disease disease : dList) {
                Map<String, Object> diseMap = new HashMap<>();

                diseMap.put("diseaseID", disease.getId());
                diseMap.put("diseCategoryID", disease.getDiseCategoryID());
                diseMap.put("diseCode", disease.getDiseCode());
                diseMap.put("diseName", disease.getDiseName());
                diseMap.put("diseICD", disease.getDiseICD());

                diseList.add(diseMap);
            }

            String diseaseJson = JSON.toJSONString(diseList);

            PrintWriter writer = response.getWriter();
            writer.write(diseaseJson);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}