package dao;

import java.sql.SQLException;
import java.util.List;

import bean.RegistForm;

public class RegistFormDao extends Dao<RegistForm> {
  private static final String TABLE_NAME = "regist_form";

  public RegistFormDao() throws ClassNotFoundException, SQLException {
    super();
  }

  public List<RegistForm> findByRecordID(int recordID) throws SQLException {
    return find(TABLE_NAME, "RecordID", Integer.toString(recordID));
  }
}