package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.Drug;

public class DrugDao extends Dao<Drug> {
    private static final String TABLE_NAME = "drug";

    public DrugDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public Drug drugFind(int id) throws SQLException {
        List<Drug> drugList = find(TABLE_NAME, "id", String.valueOf(id));
        return drugList.isEmpty()? null: drugList.get(0);
    }

    public List<Drug> drugFindAll() throws SQLException {
        return findAll(TABLE_NAME);
    }

    @Override
    protected Drug RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        long drugCode = rs.getLong("DrugCode");
        String drugName = rs.getString("DrugName");
        String drugFormat = rs.getString("DrugFormat");
        double drugPrice = rs.getDouble("DrugPrice");
        String mnemonicCode = rs.getString("MnemonicCode");

        Drug drug = new Drug(id, drugCode, drugName, drugFormat, drugPrice, mnemonicCode);
        return drug;
    }
}