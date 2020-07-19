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

    public Department deptFind(int id) throws SQLException {
        List<Department> deptList = find(TABLE_NAME, "id", String.valueOf(id));
        return deptList.isEmpty()? null: deptList.get(0);
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

        Department department = new Department(id, deptCode, deptName, deptCategoryID, deptType);

        return department;
    }
}