package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.Drugs;

public class DrugsDao extends Dao<Drugs> {
    private static final String TABLE_NAME = "drugs";

    public DrugsDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public Drugs drugFind(int id) throws SQLException {
        List<Drugs> drugList = find(TABLE_NAME, "id", String.valueOf(id));
        return drugList.isEmpty()? null: drugList.get(0);
    }

    public List<Drugs> drugFindAll() throws SQLException {
        return findAll(TABLE_NAME);
    }

    @Override
    protected Drugs RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        long drugsCode = rs.getLong("DrugsCode");
        String drugsName = rs.getString("DrugsName");
        String drugsFormat = rs.getString("DrugsFormat");
        double drugsPrice = rs.getDouble("DrugsPrice");
        String mnemonicCode = rs.getString("MnemonicCode");

        Drugs drug = new Drugs(id, drugsCode, drugsName, drugsFormat, drugsPrice, mnemonicCode);
        return drug;
    }
}