package database.mysql.dao;

import database.mysql.dto.CitronStudentAddressDTO;
import database.mysql.dto.CitronStudentDTO;
import database.mysql.dto.CitronStudentDetailDTO;

public interface CitronStudentDAO {
    boolean storeCitronStudent(CitronStudentDTO dto);
    boolean storeCitronStudent(CitronStudentDTO citronStudentDTO, CitronStudentDetailDTO citronStudentDetailDTO, CitronStudentAddressDTO citronStudentAddressDTO);
}
