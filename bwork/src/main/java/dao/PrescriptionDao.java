package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import bean.Prescription;

public class PrescriptionDao extends Dao<Prescription> {
    private static final String TABLE_NAME = "prescription";

    public PrescriptionDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public List<Prescription> findById(int id) throws SQLException {
        return find(TABLE_NAME, "id", Integer.toString(id));
    }

    public List<Prescription> findByRecordID(int recordID) throws SQLException {
        return find(TABLE_NAME, "RecordID", Integer.toString(recordID));
    }

    /**
     * 执行处方开立，若对应处方不为正在开立状态则直接返回
     * 
     * @param id
     * @return -1: 未查到或处方号重复 0: 开立成功 1: 处方已开立 2: 处方已缴费 3: 处方已退费
     * @throws SQLException
     */
    public int presEndCreate(int id) throws SQLException {
        List<Prescription> presList = find(TABLE_NAME, "id", Integer.toString(id));
        // 未查到或处方号重复
        if (presList.size() != 1)
            return -1;
        if (presList.get(0).getPresStatus() == 0) {
            String sql = "update " + TABLE_NAME + " set DiagStatus = 1 where id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }
        return presList.get(0).getPresStatus();
    }

    /**
     * 执行处方缴费，若对应处方不为未缴费状态则直接返回
     * 
     * @param id
     * @return -1: 未查到或处方号重复 0: 处方未完成开立 1: 缴费成功 2: 处方已缴费 3: 处方已退费
     * @throws SQLException
     */
    public int presPay(int id) throws SQLException {
        List<Prescription> presList = find(TABLE_NAME, "id", Integer.toString(id));
        // 未查到或处方号重复
        if (presList.size() != 1)
            return -1;
        if (presList.get(0).getPresStatus() == 0) {
            String sql = "update " + TABLE_NAME + " set DiagStatus = 2 where id = " + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }
        return presList.get(0).getPresStatus();
    }

    public void insert(Prescription prescription) throws SQLException {
        String sql = "insert into " + TABLE_NAME
                + "(id, RegistID, RecordID, DoctorID, PatiName, PresName, CreationTime, TotalPrice, PresStatus)"
                + " values (NULL, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        AssemblePS(preparedStatement, prescription);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public int create(Prescription prescription) throws SQLException {
        insert(prescription);
        int prescriptionID;

        Statement statement = connection.createStatement();
        String queryString = "select * from " + TABLE_NAME + " where recordID = " + prescription.getRecordID()
                + " ORDER BY CreationTime DESC";

        ResultSet rs = statement.executeQuery(queryString);
        if (rs.next()) {
            prescriptionID = rs.getInt("id");
        } else
            prescriptionID = -1;

        rs.close();
        statement.close();
        return prescriptionID;
    }

    @Override
    protected Prescription RSToBean(ResultSet rs) throws SQLException {
        try {
            int id = rs.getInt("id");
            int registID = rs.getInt("RegistID");
            int recordID = rs.getInt("RecordID");
            int doctorID = rs.getInt("DoctorID");
            String patiName = rs.getString("PatiName");
            String presName = rs.getString("PresName");
            Timestamp creationTime = rs.getTimestamp("creationTime");
            double totalPrice = rs.getDouble("TotalPrice");
            int presStatus = rs.getInt("PresStatus");
            return new Prescription(id, registID, recordID, doctorID, patiName, presName, creationTime, totalPrice,
                    presStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void AssemblePS(PreparedStatement preparedStatement, Prescription prescription) throws SQLException {
        preparedStatement.setInt(1, prescription.getRegistID());
        preparedStatement.setInt(2, prescription.getRecordID());
        preparedStatement.setInt(3, prescription.getDoctorID());
        preparedStatement.setString(4, prescription.getPatiName());
        preparedStatement.setString(5, prescription.getPresName());
        preparedStatement.setTimestamp(6, prescription.getCreationTime());
        preparedStatement.setDouble(7, prescription.getTotalPrice());
        preparedStatement.setInt(8, prescription.getPresStatus());
    }
}