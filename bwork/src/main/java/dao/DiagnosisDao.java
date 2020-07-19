package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Diagnosis;

public class DiagnosisDao extends Dao<Diagnosis> {
    private static final String TABLE_NAME = "diagnosis";

    public DiagnosisDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public void insert(Diagnosis diagnosis) throws SQLException {
        String sql = "insert into " + TABLE_NAME + " (id, RegistID, DoctorID, DiseaseID, DiseName, DiagInfo)"
                + " values (NULL, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        AssemblePS(preparedStatement, diagnosis);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private void AssemblePS(PreparedStatement preparedStatement, Diagnosis diagnosis) throws SQLException {
        preparedStatement.setInt(1, diagnosis.getRegistID());
        preparedStatement.setInt(2, diagnosis.getDoctorID());
        preparedStatement.setInt(3, diagnosis.getDiseaseID());
        preparedStatement.setString(4, diagnosis.getDiseName());
        preparedStatement.setString(5, diagnosis.getDiagInfo());
    }
}