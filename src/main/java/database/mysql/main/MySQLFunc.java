package database.mysql.main;

import java.sql.Connection;
import java.sql.SQLException;

public interface MySQLFunc {
    Connection open();
    boolean checkConnection();
    void close(Connection c) throws SQLException;
}
