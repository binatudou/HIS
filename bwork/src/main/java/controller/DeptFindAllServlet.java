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

import bean.Department;
import service.DepartmentService;

@WebServlet(name = "DeptFindAllServlet", urlPatterns = { "/deptFindAll" })
public class DeptFindAllServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 获取科室信息
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Map<String, Object>> deptOptionList = new ArrayList<>();

            //获取表中全部数据
            List<Department> deptList = DepartmentService.deptFindAll();
            for (Department department : deptList) {
                Map<String, Object> deptOption = new HashMap<>();

                deptOption.put("id", department.getId());
                deptOption.put("deptName", department.getDeptName());

                deptOptionList.add(deptOption);
            }

            String deptOptionJson = JSON.toJSONString(deptOptionList);

            PrintWriter writer = response.getWriter();
            writer.write(deptOptionJson);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}