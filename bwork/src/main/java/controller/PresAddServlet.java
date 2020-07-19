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

import service.PrescriptionService;

@WebServlet(name = "PresAddServlet", urlPatterns = { "/presAdd" })
public class PresAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String doctorID = String.valueOf(request.getSession().getAttribute("doctorID"));
            Map<String, Object> resultMap = new HashMap<>();
            // 无权限开立
            if (doctorID == null) {
                resultMap.put("resultCode", -1);
            } else { //
                Map<String, String[]> formMap = request.getParameterMap();
                
                PrescriptionService.add(formMap, doctorID);

                resultMap.put("resultCode", 0);

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