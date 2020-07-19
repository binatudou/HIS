package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import bean.PresItem;

public class PresItemDao extends Dao<PresItem> {
    private static final String TABLE_NAME = "prescription_item";

    public PresItemDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public List<PresItem> findByPrescriptionID(int prescriptionID) throws SQLException {
    return find(TABLE_NAME, "PrescriptionID", Integer.toString(prescriptionID));
    }

    // 执行缴费，若对应记录不为未缴费状态则直接返回
    public int payDrugs(int prescriptionID) throws SQLException {
        List<PresItem> pItemList = find(TABLE_NAME, "id", Integer.toString(prescriptionID));
        // 未查到处方或药品记录
        if (pItemList.isEmpty())
            return -1;
        for (PresItem presItem : pItemList) {
            // 处方中药品记录不为未缴费状态
            if (presItem.getPaymentStatus() != 0) {
                return 1;
            }
        }
        // 执行开药
        String sql = "update " + TABLE_NAME + " set DiagStatus = 1 where id = " + prescriptionID;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();

        return 0;
    }

    // 执行开药，若对应记录不为已缴费状态则直接返回
    public int giveDrugs(int prescriptionID) throws SQLException {
        List<PresItem> pItemList = find(TABLE_NAME, "id", Integer.toString(prescriptionID));
        // 未查到处方或药品记录
        if (pItemList.isEmpty())
            return -1;
        for (PresItem presItem : pItemList) {
            // 处方中药品记录不为已缴费状态
            if (presItem.getPaymentStatus() != 1) {
                return 1;
            }
        }
        // 执行开药
        String sql = "update " + TABLE_NAME + " set DiagStatus = 1 where id = " + prescriptionID;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();

        return 0;
    }

    public void insert(PresItem pItem) throws SQLException {
        String sql = "insert into " + TABLE_NAME
                + "(id, PrescriptionID, DrugID, DrugName, DrugPrice, DrugNumber, Description, PaymentStatus)"
                + " values (NULL, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        AssemblePS(preparedStatement, pItem);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    protected PresItem RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int prescriptionID = rs.getInt("PrescriptionID");
        int drugID = rs.getInt("DrugID");
        String drugName = rs.getString("DrugName");
        Double drugPrice = rs.getDouble("DrugPrice");
        int drugNumber = rs.getInt("DrugNumber");
        String description = rs.getString("Description");
        int paymentStatus = rs.getInt("PaymentStatus");

        return new PresItem(id, prescriptionID, drugID, drugName, drugPrice, drugNumber, description, paymentStatus);
    }

    private void AssemblePS(PreparedStatement preparedStatement, PresItem pItem) throws SQLException {
        preparedStatement.setInt(1, pItem.getPrescriptionID());
        preparedStatement.setInt(2, pItem.getDrugID());
        preparedStatement.setString(3, pItem.getDrugName());
        preparedStatement.setDouble(4, pItem.getDrugPrice());
        preparedStatement.setInt(5, pItem.getDrugNumber());
        preparedStatement.setString(6, pItem.getDescription());
        preparedStatement.setInt(7, pItem.getPaymentStatus());
    }
}