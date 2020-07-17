package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Patient;
import service.PatientService;

@WebServlet(name = "PatientFindServlet", urlPatterns = { "/patiFind" })
public class PatientFindServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(request.getParameter("recordID"));
            Patient patient = PatientService.find(id);
            request.setAttribute("patient", patient);
            request.getRequestDispatcher("department.jsp").forward(request, response);

            // String id = request.getParameter("id");
            // String department = request.getParameter("department");
            // String name = request.getParameter("name");
            // String sex = request.getParameter("sex");
            // String telephone = request.getParameter("telephone");
            // String strBirthday = request.getParameter("birthday");
            // Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(strBirthday);

            // Member member = new Member();

            // member.setId(Integer.parseInt(id));
            // member.setDepartment(Integer.parseInt(department));
            // member.setName(name);
            // member.setSex(sex);
            // member.setTelephone(telephone);
            // member.setBirthday(birthday);

            // MemberService.update(member);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}