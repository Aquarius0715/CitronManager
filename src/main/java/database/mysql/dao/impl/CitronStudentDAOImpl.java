package database.mysql.dao.impl;

import database.mysql.dao.CitronStudentDAO;
import database.mysql.dto.CitronStudentDTO;
import database.mysql.impl.MySQLManagerImpl;

public class CitronStudentDAOImpl implements CitronStudentDAO {

    @Override
    public boolean storeCitronStudent(CitronStudentDTO dto) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("storeCitronStudent");
        String sql = "INSERT INTO citron_students";
        return false;
    }
}
