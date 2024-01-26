package database.mysql.dao;

import database.mysql.dto.CitronStudentDTO;

public interface CitronStudentDAO {
    boolean storeCitronStudent(CitronStudentDTO dto);
}
