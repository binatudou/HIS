package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.Department;

public class DepartmentDao extends Dao<Department> {
    private static final String TABLE_NAME = "department";

    public DepartmentDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public List<Department> deptFindAll() throws SQLException {
        return findAll(TABLE_NAME);
    }

    @Override
    protected Department RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String deptCode = rs.getString("DeptCode");
        String deptName = rs.getString("DeptName");
        int deptCategoryID = rs.getInt("DeptCategoryID");
        int deptType = rs.getInt("DeptType");

        Department patient = new Department(id, deptCode, deptName, deptCategoryID, deptType);

        return patient;
    }
}