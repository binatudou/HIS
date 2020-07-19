package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.Disease;

public class DiseaseDao extends Dao<Disease> {
    private static final String TABLE_NAME = "disease";

    public DiseaseDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public List<Disease> diseFindAll() throws SQLException {
        return findAll(TABLE_NAME);
    }

    @Override
    protected Disease RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int diseCategoryID = rs.getInt("DiseCategoryID");
        String diseCode = rs.getString("DiseCode");
        String diseName = rs.getString("DiseName");
        String diseICD = rs.getString("DiseICD");

        Disease disease = new Disease(id, diseCategoryID, diseCode, diseName, diseICD);
        return disease;
    }
}