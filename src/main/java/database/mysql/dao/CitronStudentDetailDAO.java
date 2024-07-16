package database.mysql.dao;

import database.mysql.dto.CitronStudentDetailDTO;

public interface CitronStudentDetailDAO {
    boolean storeCitronStudentDetail(CitronStudentDetailDTO dto);
}
