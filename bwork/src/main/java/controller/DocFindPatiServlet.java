package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.RegistFormService;

@WebServlet(name = "DocFindPatiServlet", urlPatterns = { "/docFindPati" })
public class DocFindPatiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      int doctorID = Integer.parseInt(String.valueOf(request.getSession().getAttribute("doctorID")));
      Map<String, Object> rFormMap = RegistFormService.docFindPati(doctorID);
      String rItemJson = JSON.toJSONString(rFormMap);
      //test
      System.out.println(rItemJson);
      //test

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