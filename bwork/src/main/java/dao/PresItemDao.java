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

    /**
     * 对未缴费处方中的处方明细执行缴费
     * 
     * @param prescriptionID 待执行处方id
     * @return -1: 未查到处方或药品记录; 0: 可执行缴费操作; n: 第n个处方明细内容错误(从1起数)
     * @throws SQLException
     */
    public int payDrugs(int prescriptionID) throws SQLException {
        List<PresItem> pItemList = find(TABLE_NAME, "PrescriptionID", Integer.toString(prescriptionID));
        // 未查到处方或药品记录
        if (pItemList.isEmpty())
            return -1;
        //遍历处方，检查处方明细
        for (int i = 0; i < pItemList.size(); i++) {
            PresItem presItem = pItemList.get(i);
            // 处方明细不为未缴费状态
            if (presItem.getPaymentStatus() != 0) {
                return i + 1;
            }
        }
        
        // 执行开药
        String sql = "update " + TABLE_NAME + " set PaymentStatus = 1 where id = " + prescriptionID;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        return 0;
    }

    /**
     * 对已缴费处方明细执行开药
     * @param presItemID 处方明细id
     * @return paymentStatus 处方明细状态
     * @throws SQLException
     */
    public int giveDrug(int presItemID) throws SQLException {
        List<PresItem> resultList = find(TABLE_NAME, "id", Integer.toString(presItemID));
        // 未查到处方或药品记录
        if (resultList.isEmpty())
            return -1;

        // 仅对已缴费明细执行开药
        PresItem pItem = resultList.get(0);
        int paymentStatus = pItem.getPaymentStatus();
        if (paymentStatus == 1) {
            // 执行开药
            String sql = "update " + TABLE_NAME + " set PaymentStatus = 2 where id = " + pItem.getId();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }

        return paymentStatus;
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