package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao<T> {
    protected Connection connection = null;

    public Dao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/HIS";
        String args = "?characterEncoding=utf-8&serverTimezone=GMT%2B8";
        this.connection = DriverManager.getConnection(url + args, "root", "");
    }

    /**
     * 查询并返回筛选记录
     * 
     * @param tableName   表名
     * @param columnLabel 字段名
     * @param parameter   字段内容
     * @return List
     */
    public List<T> find(String tableName, String columnLabel, String parameter) throws SQLException {
        Statement statement = connection.createStatement();
        String queryString = "select * from " + tableName + " where " + columnLabel + " = " + parameter;
        ResultSet rs = statement.executeQuery(queryString);
        ArrayList<T> list = new ArrayList<>();
        while (rs.next()) {
            list.add(RSToBean(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    /**
     * 获取表中所有记录
     * 
     * @param tableName 表名
     * @return List
     */
    public List<T> findAll(String tableName) throws SQLException {
        Statement statement = connection.createStatement();
        String queryString = "select * from " + tableName;
        ResultSet rs = statement.executeQuery(queryString);
        ArrayList<T> list = new ArrayList<>();
        while (rs.next()) {
            list.add(RSToBean(rs));
        }
        rs.close();
        statement.close();
        return list;
    }

    public void close() throws SQLException {
        this.connection.close();
    }

    protected T RSToBean(ResultSet rs) throws SQLException {
        return null;
    }
}