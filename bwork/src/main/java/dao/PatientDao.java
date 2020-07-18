package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
        ResultSet rs = statement.executeQuery("select  from " + TABLE_NAME);
        ArrayList<Patient> list = new ArrayList<>();
        while (rs.next()) {
            list.add(RSToBean(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    public void add(Patient patient) throws SQLException {
        String sql = "insert into " + TABLE_NAME + " (id, RecordID, PatiName, Sex, Birthday, IdNumber, PatiAddress) "
                + "values (NULL, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        AssemblePS(preparedStatement, patient);
        preparedStatement.executeUpdate();
        preparedStatement.close();
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

    private void AssemblePS(PreparedStatement preparedStatement, Patient patient) throws SQLException {
        preparedStatement.setInt(1, patient.getRecordID());
        preparedStatement.setString(2, patient.getPatiName());
        preparedStatement.setInt(3, patient.getSex());
        preparedStatement.setDate(4, patient.getBirthday());
        preparedStatement.setString(5, patient.getIdNumber());
        preparedStatement.setString(6, patient.getPatiAddress());
    }

    public static void main(String[] args) {
    try {
    PatientDao pDao = new PatientDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date uDate = sdf.parse("2000-01-01");
    Date sqlDate = new Date(uDate.getTime());
    Patient patient = new Patient(0, 413, "测试413", 0, sqlDate, "18", "测试地址");
    pDao.add(patient);
    pDao.close();
    } catch (Exception e) {
    e.printStackTrace();
    }
    }
}

// package dao;

// import bean.Member;

// import java.sql.; import java.util.ArrayList;

// public class MemberDao { private static final String TABLE_NAME = "Member";
// private Connection connection = null;

// public MemberDao() throws ClassNotFoundException, SQLException {
// Class.forName("com.mysql.cj.jdbc.Driver"); String url =
// "jdbc:mysql://localhost:3306/MS"; String args =
// "?characterEncoding=utf-8&serverTimezone=GMT%2B8"; this.connection =
// DriverManager.getConnection(url + args, "root", ""); }

// public void close() throws SQLException { this.connection.close(); }

// public void add(Member member) throws SQLException { String sql =
// "insert into " + TABLE_NAME +
// " (id, department, name, telephone, sex, birthday) " +
// "values (NULL, ?, ?, ?, ?, ?)"; PreparedStatement preparedStatement =
// connection.prepareStatement(sql); AssemblePS(preparedStatement, member);
// preparedStatement.executeUpdate(); preparedStatement.close(); }

// public void update(Member member) throws SQLException { String sql =
// "update " + TABLE_NAME +
// " set department = ?, name = ?, telephone = ?, sex = ?, birthday = ?" +
// " where id = ?"; PreparedStatement preparedStatement =
// connection.prepareStatement(sql); AssemblePS(preparedStatement, member);
// preparedStatement.setInt(6, member.getId());
// preparedStatement.executeUpdate(); preparedStatement.close(); }

// public void deleteById(int id) throws SQLException { Statement statement =
// connection.createStatement(); statement.executeUpdate("delete from " +
// TABLE_NAME + " where id = " + id); statement.close(); }

// public Member findById(int id) throws SQLException { Statement statement =
// connection.createStatement(); ResultSet rs =
// statement.executeQuery("select from " + TABLE_NAME + " where id = " + id);
// rs.next(); Member member = RSToBean(rs); rs.close();

// return member; }

// public ArrayList<Member> findByDep(int d_id) throws SQLException { Statement
// statement = connection.createStatement(); ResultSet rs =
// statement.executeQuery("select from " + TABLE_NAME + " where department = "
// + d_id); ArrayList<Member> list = new ArrayList<>(); while (rs.next()) {
// list.add(RSToBean(rs)); } rs.close(); statement.close(); return list; }

// public ArrayList<Member> findAll() throws SQLException { Statement statement
// = connection.createStatement(); ResultSet rs =
// statement.executeQuery("select from " + TABLE_NAME); ArrayList<Member> list
// = new ArrayList<>(); while (rs.next()) { list.add(RSToBean(rs)); }
// rs.close(); statement.close(); return list; }

// private Member RSToBean(ResultSet rs) throws SQLException { int id =
// rs.getInt("id"); int department = rs.getInt("department"); String name =
// rs.getString("name"); String sex = rs.getString("sex"); String telephone =
// rs.getString("telephone"); Date birthday = rs.getDate("birthday");

// Member member = new Member();

// member.setId(id); member.setDepartment(department); member.setName(name);
// member.setSex(sex); member.setBirthday(birthday);
// member.setTelephone(telephone);

// return member; }

// private void AssemblePS(PreparedStatement preparedStatement, Member member)
// throws SQLException { preparedStatement.setInt(1, member.getDepartment());
// preparedStatement.setString(2, member.getName());
// preparedStatement.setString(3, member.getTelephone());
// preparedStatement.setString(4, member.getSex()); preparedStatement.setDate(5,
// new java.sql.Date(member.getBirthday().getTime())); }

// }
