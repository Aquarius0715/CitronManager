package database.mysql;

import database.mysql.model.JDBCModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MySQLManager {
    void loadConfig();
    void commit();
    boolean connect(JDBCModel jdbcModel) throws SQLException;
    boolean connectCheck();
    boolean execute(String query);
    ResultSet query(String query);
    void close();
    String escapeStringForMySQL(String str);
}
