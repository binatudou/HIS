package service;

import java.sql.SQLException;
import java.util.List;

import bean.Department;
import dao.DepartmentDao;

public class DepartmentService {
    /**
     * 返回全部科室
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Department> deptFindAll() throws SQLException, ClassNotFoundException {
        DepartmentDao deptDao = new DepartmentDao();
        List<Department> deptList = deptDao.deptFindAll();
        deptDao.close();
        return deptList;
    }

    /**
     * 根据id找到对应科室
     * 
     * @param id
     * @return department
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Department deptFind(int id) throws SQLException, ClassNotFoundException {
        DepartmentDao deptDao = new DepartmentDao();
        Department department = deptDao.deptFind(id);
        deptDao.close();
        return department;
    }
}