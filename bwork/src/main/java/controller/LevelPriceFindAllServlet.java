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

import bean.LevelPrice;
import service.LevelPriceService;

@WebServlet(name = "LevelPriceFindAllServlet", urlPatterns = { "/lPriceFindAll" })
public class LevelPriceFindAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Map<String, Object>> lPriceDataList = new ArrayList<>();

            // 获取表中全部数据
            List<LevelPrice> lPriceList = LevelPriceService.lPriceFindAll();
            for (LevelPrice lPrice : lPriceList) {
                Map<String, Object> lPriceData = new HashMap<>();

                lPriceData.put("id", lPrice.getId());
                lPriceData.put("levelCode", lPrice.getLevelCode());
                lPriceData.put("levelPrice", lPrice.getLevelPrice());

                lPriceDataList.add(lPriceData);
            }

            String lPriceDataJson = JSON.toJSONString(lPriceDataList);

            PrintWriter writer = response.getWriter();
            writer.write(lPriceDataJson);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}