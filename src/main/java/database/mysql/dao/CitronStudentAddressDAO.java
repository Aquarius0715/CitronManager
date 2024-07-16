package database.mysql.dao;

import database.mysql.dto.CitronStudentAddressDTO;

public interface CitronStudentAddressDAO {
    boolean storeCitronStudentAddress(CitronStudentAddressDTO dto);
}
