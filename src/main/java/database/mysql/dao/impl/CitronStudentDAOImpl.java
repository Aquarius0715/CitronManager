package database.mysql.dao.impl;

import database.mysql.dao.CitronStudentDAO;
import database.mysql.dto.CitronStudentAddressDTO;
import database.mysql.dto.CitronStudentDTO;
import database.mysql.dto.CitronStudentDetailDTO;
import database.mysql.logic.impl.MySQLLogicImpl;
import database.mysql.main.impl.MySQLManagerImpl;
import struct.EnrollmentStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CitronStudentDAOImpl implements CitronStudentDAO {
    MySQLLogicImpl mySQLLogic = new MySQLLogicImpl();

    @Override
    public boolean storeCitronStudent(CitronStudentDTO dto) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("storeCitronStudent(Only base table)");
        String sql = "INSERT INTO citron_students(" +
                "student_id," +
                "last_name," +
                "first_name," +
                "last_name_kana," +
                "first_name_kana," +
                "emergency_call_number," +
                "emergency_relationship" +
                ") VALUES (" +
                mySQLLogic.escapeString(dto.getStudentId()) + "," +
                mySQLLogic.escapeString(dto.getLastName()) + "," +
                mySQLLogic.escapeString(dto.getFirstName()) + "," +
                mySQLLogic.escapeString(dto.getLastNameKana()) + "," +
                mySQLLogic.escapeString(dto.getFirstNameKana()) + "," +
                mySQLLogic.escapeString(dto.getEmergencyCallNumber()) + "," +
                mySQLLogic.escapeString(dto.getEmergencyRelationship()) + ");";

        boolean result = mySQLManager.execute(sql);
        mySQLManager.close();
        return result;
    }
    @Override
    public boolean storeCitronStudent(CitronStudentDTO citronStudentDTO, CitronStudentDetailDTO citronStudentDetailDTO, CitronStudentAddressDTO citronStudentAddressDTO) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("storeCitronStudent(Every student table)");
        String sql = "INSERT INTO citron_students(" +
                "last_name," +
                "first_name," +
                "last_name_kana," +
                "first_name_kana," +
                "emergency_call_number," +
                "emergency_relationship" +
                ") VALUES (" +
                mySQLLogic.escapeString(citronStudentDTO.getLastName()) + "," +
                mySQLLogic.escapeString(citronStudentDTO.getFirstName()) + "," +
                mySQLLogic.escapeString(citronStudentDTO.getLastNameKana()) + "," +
                mySQLLogic.escapeString(citronStudentDTO.getFirstNameKana()) + "," +
                mySQLLogic.escapeString(citronStudentDTO.getEmergencyCallNumber()) + "," +
                mySQLLogic.escapeString(citronStudentDTO.getEmergencyRelationship()) + ");\n" +
                "INSERT INTO citron_students_details(" +
                "student_id," +
                "parent_last_name," +
                "parent_first_name," +
                "parent_last_name_kana," +
                "parent_first_name_kana," +
                "tel_number," +
                "phone_number," +
                "email_address," +
                "birthday," +
                "family_relationship," +
                "enrollment_date," +
                "enrollment_status" +
                ") VALUES (" +
                "(SELECT student_id FROM citron_students)," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getParentLastName()) + "," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getParentFirstName()) + "," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getParentLastNameKana()) + "," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getParentFirstNameKana()) + "," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getTelNumber()) + "," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getPhoneNumber()) + "," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getEmailAddress()) + "," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getBirthday()) + "," +
                mySQLLogic.escapeString(citronStudentDetailDTO.getFamilyRelationship()) + "," +
                mySQLLogic.escapeString(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) + "," +
                mySQLLogic.escapeString(String.valueOf(EnrollmentStatus.WAITING)) + ");\n" +
                "INSERT INTO citron_students_address(" +
                "student_id," +
                "zip_code," +
                "prefecture," +
                "city," +
                "street," +
                "apartment_number," +
                "detail" +
                ") VALUES (" +
                "(SELECT student_id FROM citron_students)," +
                mySQLLogic.escapeString(citronStudentAddressDTO.getZipCode()) + "," +
                mySQLLogic.escapeString(citronStudentAddressDTO.getPrefecture()) + "," +
                mySQLLogic.escapeString(citronStudentAddressDTO.getCity()) + "," +
                mySQLLogic.escapeString(citronStudentAddressDTO.getStreet()) + "," +
                mySQLLogic.escapeString(citronStudentAddressDTO.getApartmentNumber()) + "," +
                mySQLLogic.escapeString(citronStudentAddressDTO.getDetail()) + ");\n";
                boolean result = mySQLManager.execute(sql);
                mySQLManager.close();
        return result;
    }
}
