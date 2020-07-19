package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.LevelPrice;

public class LevelPriceDao extends Dao<LevelPrice> {
    private static final String TABLE_NAME = "level_price";

    public LevelPriceDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public List<LevelPrice> lPriceFindAll() throws SQLException {
        return findAll(TABLE_NAME);
    }

    @Override
    protected LevelPrice RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int levelCode = rs.getInt("LevelCode");
        double levelPrice = rs.getDouble("levelPrice");

        LevelPrice lPrice = new LevelPrice(id, levelCode, levelPrice);

        return lPrice;
    }
}