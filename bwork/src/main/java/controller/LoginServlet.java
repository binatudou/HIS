package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        //由于时间紧急，未连接至数据库
        if (userID.equals("admin") && password.equals("123")) {
            request.getSession().setAttribute("user", "admin");
            request.getSession().setAttribute("operatorID", 1);
            request.getSession().setAttribute("doctorID", 1);
            request.getSession().setAttribute("scheduleID", 1);
            request.getSession().setAttribute("authority", "admin");
            request.getSession().setAttribute("loginSuccess", true);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}