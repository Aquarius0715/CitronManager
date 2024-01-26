package database.mysql.dao;

import database.mysql.dto.CitronUserDTO;

import java.util.ArrayList;

public interface CitronUserDAO {
    ArrayList<CitronUserDTO> loadAllUsers();
    CitronUserDTO loadUserByUsername(String username);

    String loadPasswordByUsername(String username);
    int countUsersByUsernameAndPassword(String username, String password);
}
