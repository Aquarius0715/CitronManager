package database.mysql.dao.impl;

import database.mysql.dao.CitronUserDAO;
import database.mysql.dto.CitronUserDTO;
import database.mysql.impl.MySQLManagerImpl;
import org.springframework.security.core.parameters.P;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CitronUserDAOImpl implements CitronUserDAO {
    @Override
    public ArrayList<CitronUserDTO> loadAllUsers() {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("loadAllUsers");
        String sql = "SELECT * FROM citron_users;";
        ResultSet resultSet = mySQLManager.query(sql);
        ArrayList<CitronUserDTO> citronUserDTOes = new ArrayList<>();
        try {
            while (resultSet.next()) {
                CitronUserDTO citronUserDTO = new CitronUserDTO(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("registration_data")
                );
            }
            resultSet.close();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        mySQLManager.close();
        return citronUserDTOes;
    }

    @Override
    public CitronUserDTO loadUserByUsername(String username) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("loadUserByUsername");
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM citron_users WHERE username = '");
        sql.append(mySQLManager.escapeStringForMySQL(username));
        sql.append("';");
        ResultSet resultSet = mySQLManager.query(sql.toString());
        CitronUserDTO citronUserDTO = null;
        try {
            if (resultSet.next()) {
                citronUserDTO = new CitronUserDTO(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("registration_data")
                );
            } else {
                System.err.println("returned null object because ResultSet is Empty.");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        mySQLManager.close();
        return citronUserDTO;
    }

    @Override
    public String loadPasswordByUsername(String username) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("loadPasswordByUsername");
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT password FROM citron_users WHERE username = '");
        sql.append(mySQLManager.escapeStringForMySQL(username));
        sql.append("';");
        ResultSet resultSet = mySQLManager.query(sql.toString());
        try {
            if (resultSet.next()) {
                return resultSet.getString("password");
            } else {
                System.err.println("Return null object because ResultSet is Empty.");
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return null;
    }

    @Override
    public int countUsersByUsernameAndPassword(String username, String password) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("countUsersByUsernameAndPassword");
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT username FROM citron_users WHERE username = '");
        sql.append(mySQLManager.escapeStringForMySQL(username));
        sql.append("' AND '");
        sql.append(mySQLManager.escapeStringForMySQL(password));
        sql.append("';");
        ResultSet resultSet = mySQLManager.query(sql.toString());
        int recordCount = 0;
        try {
            while (resultSet.next()) {
                recordCount += 1;
            }
            resultSet.close();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        mySQLManager.close();
        return recordCount;
    }
}
