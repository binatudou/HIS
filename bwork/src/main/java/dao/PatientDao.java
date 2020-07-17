package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Patient;

public class PatientDao extends Dao<Patient> {
    private static final String TABLE_NAME = "patient";

    public PatientDao() throws ClassNotFoundException, SQLException {
        super();
    }

    public Patient findByRecordID(int recordID) throws SQLException {
        List<Patient> patiList = find(TABLE_NAME, "RecordID", Integer.toString(recordID));
        if (patiList.isEmpty())
            return null;

        Patient patient = patiList.get(0);
        return patient;
    }

    public ArrayList<Patient> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from " + TABLE_NAME);
        ArrayList<Patient> list = new ArrayList<>();
        while (rs.next()) {
            list.add(RSToBean(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    @Override
    protected Patient RSToBean(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int recordID = rs.getInt("RecordID");
        String patiName = rs.getString("PatiName");
        int sex = rs.getInt("Sex");
        Date birthday = rs.getDate("Birthday");
        String idNumber = rs.getString("IdNumber");
        String patiAddress = rs.getString("PatiAddress");

        Patient patient = new Patient(id, recordID, patiName, sex, birthday, idNumber, patiAddress);

        return patient;
    }

    // private void AssemblePS(PreparedStatement preparedStatement, Department
    // Department) throws SQLException {
    // preparedStatement.setString(1, Department.getName());
    // preparedStatement.setString(2, Department.getAuthority());
    // preparedStatement.setString(3, Department.getDescription());
    // }

    public static void main(String[] args) {
        try {
            PatientDao pDao = new PatientDao();
            Patient patient = pDao.findByRecordID(1);
            System.out.println(patient.getId());
            System.out.println(patient.getPatiName());
            System.out.println(patient.getBirthday().toString());
            pDao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
