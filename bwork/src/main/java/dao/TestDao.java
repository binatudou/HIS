package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDao extends Dao<String> {
    public TestDao() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    protected String RSToBean(ResultSet rs) throws SQLException {
        return "";
    }

    private void AssemblePS(PreparedStatement preparedStatement, String string) throws SQLException {
        preparedStatement.setString(1, "");
    }
}