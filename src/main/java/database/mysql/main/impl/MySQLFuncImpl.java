package database.mysql.main.impl;

import database.mysql.main.MySQLFunc;
import database.mysql.model.JDBCModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLFuncImpl implements MySQLFunc {
    JDBCModel jdbcModel;
    Connection conn;
    public MySQLFuncImpl(JDBCModel jdbcModel) {
        this.jdbcModel = jdbcModel;
    }
    @Override
    public Connection open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            StringBuilder url = new StringBuilder();
            url.append("jdbc:mysql://");
            url.append(jdbcModel.host);
            url.append(":");
            url.append(jdbcModel.port);
            url.append("/");
            url.append(jdbcModel.db);
            url.append("?allowPublicKeyRetrieval=true&useSSL=false");
            //url = new StringBuilder("jdbc:mysql://localhost:3306/citron_kids_manager");
            //conn = DriverManager.getConnection(url.toString(), jdbcModel.user, jdbcModel.pass);
            conn = DriverManager.getConnection(url.toString(), jdbcModel.user, jdbcModel.pass);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Could not connect to MySQL server, error code: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver was not found in this machine.");
        }
        return conn;
    }

    @Override
    public boolean checkConnection() {
        return conn != null;
    }

    @Override
    public void close(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
