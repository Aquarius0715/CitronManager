package database.mysql.dao.impl;

import database.mysql.logic.impl.MySQLLogicImpl;
import database.mysql.main.impl.MySQLManagerImpl;
import database.mysql.dao.CitronUserDAO;
import database.mysql.dto.CitronUserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CitronUserDAOImpl implements CitronUserDAO {
    MySQLLogicImpl mySQLLogic = new MySQLLogicImpl();
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
        String sql = "SELECT * FROM citron_users WHERE username = " +
                mySQLLogic.escapeString(username) +
                ";";
        ResultSet resultSet = mySQLManager.query(sql);
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
        String sql = "SELECT password FROM citron_users WHERE username = " +
                mySQLLogic.escapeString(username) +
                ";";
        ResultSet resultSet = mySQLManager.query(sql);
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
        String sql = "SELECT username FROM citron_users WHERE username = " +
                mySQLLogic.escapeString(username) +
                " AND " +
                mySQLLogic.escapeString(password) +
                ";";
        ResultSet resultSet = mySQLManager.query(sql);
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
