package database.mysql.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import database.mysql.MySQLManager;
import database.mysql.model.JDBCModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManagerImpl implements MySQLManager {
    private JDBCModel jdbcModel;
    private boolean isDebugMode;
    private boolean isConnected = false;
    private Statement statement;
    private Connection connection;
    private MySQLFuncImpl mySQLFunc;
    private final String connectionName;

    public MySQLManagerImpl(String connectionName) {
        jdbcModel = new JDBCModel();
        loadConfig();
        isDebugMode = true;
        isConnected = false;
        this.connectionName = connectionName;
    }

    @Override
    public void loadConfig() {

        /*
        try {
            String yaml = Files.readString(Paths.get("src/main/resources/settings.yml"));
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            jdbcModel = mapper.readValue(yaml, JDBCModel.class);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        */

        jdbcModel.db = "citron_kids_manager";
        jdbcModel.host = "localhost";
        jdbcModel.pass = "";
        jdbcModel.port = "3306";
        jdbcModel.user = "root";


    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean connect(JDBCModel jdbcModel) {
        this.jdbcModel = jdbcModel;
        mySQLFunc = new MySQLFuncImpl(jdbcModel);
        connection = mySQLFunc.open();
        if (connection == null) {
            System.err.println("Failed to Open MySQL");
            return false;
        }
        StringBuilder msg;
        try {
            statement = connection.createStatement();
            isConnected = true;
            msg = new StringBuilder();
            msg.append("[");
            msg.append(connectionName);
            msg.append("] Connected to the database");
            System.out.println(msg);
        } catch (SQLException e) {
            isConnected = false;
            msg = new StringBuilder();
            msg.append("[");
            msg.append(connectionName);
            msg.append("] Could not connect to the database");
            e.fillInStackTrace();
        }
        mySQLFunc.close(connection);
        return isConnected;
    }

    @Override
    public boolean connectCheck() {
        return connect(this.jdbcModel);
    }
    @Override
    public boolean execute(String query) {
        StringBuilder msg;
        mySQLFunc = new MySQLFuncImpl(jdbcModel);
        connection = mySQLFunc.open();
        if (connection == null) {
            System.err.println("Failed to open MySQL");
            return false;
        }
        boolean ret = true;
        if (isDebugMode) {
            System.out.println(query);
        }
        try {
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            msg = new StringBuilder();
            msg.append("[");
            msg.append(connectionName);
            msg.append("] Error executing statement: ");
            msg.append(e.getErrorCode());
            msg.append(":");
            msg.append(e.getMessage());
            System.err.println(msg);
            ret = false;
            e.fillInStackTrace();
        }
        close();
        return ret;
    }

    @Override
    public ResultSet query(String query) {
        StringBuilder msg;
        mySQLFunc = new MySQLFuncImpl(jdbcModel);
        connection = mySQLFunc.open();
        ResultSet resultSet = null;
        if (connection == null) {
            System.err.println("failed to open MySQL");
            return null;
        }
        if (isDebugMode) {
            System.out.println(query);
        }
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.fillInStackTrace();
            msg = new StringBuilder();
            msg.append("[");
            msg.append(connectionName);
            msg.append("] Error executing query: ");
            msg.append(e.getErrorCode());
            msg.append(":");
            msg.append(e.getMessage());
            System.err.println(msg);
        }
        return resultSet;
    }

    @Override
    public void close() {
        try {
            statement.close();
            connection.close();
            mySQLFunc.close(connection);
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }

    @Override
    public String escapeStringForMySQL(String str) {
        return str.replace("\\", "\\\\")
                .replace("\b", "\\b")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t")
                .replace("\\x1A", "\\Z")
                .replace("\\x00", "\\0")
                .replace("'", "\\'")
                .replace("\"", "\\\"");
    }

    public void setIsDebugMode(boolean isDebugMode) {
        this.isDebugMode = isDebugMode;
    }
    public boolean getIsDebugMode() {
        return isDebugMode;
    }
}
