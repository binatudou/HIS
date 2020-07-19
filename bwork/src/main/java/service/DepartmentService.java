package service;

import java.sql.SQLException;
import java.util.List;

import bean.Department;
import dao.DepartmentDao;

public class DepartmentService {
    public static List<Department> deptFindAll() throws SQLException, ClassNotFoundException {
        DepartmentDao deptDao = new DepartmentDao();
        List<Department> deptList = deptDao.deptFindAll();
        deptDao.close();
        return deptList;
    }

    public static Department deptFind(int id) throws SQLException, ClassNotFoundException {
        DepartmentDao deptDao = new DepartmentDao();
        Department department = deptDao.deptFind(id);
        deptDao.close();
        return department;
    }
}