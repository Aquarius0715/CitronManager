package database.mysql.dao.impl;

import database.mysql.dto.CitronStudentDetailDTO;
import database.mysql.logic.impl.MySQLLogicImpl;
import database.mysql.dao.CitronStudentDetailDAO;
import database.mysql.main.impl.MySQLManagerImpl;
import struct.EnrollmentStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CitronStudentDetailDAOImpl implements CitronStudentDetailDAO {

    MySQLLogicImpl mySQLLogic = new MySQLLogicImpl();

    @Override
    public boolean storeCitronStudentDetail(CitronStudentDetailDTO dto) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("storeCitronStudentDetail");
        String sql = "INSERT INTO citron_students_details(" +
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
                mySQLLogic.escapeString(dto.getStudent_id()) + "," +
                mySQLLogic.escapeString(dto.getParentLastName()) + "," +
                mySQLLogic.escapeString(dto.getParentFirstName()) + "," +
                mySQLLogic.escapeString(dto.getParentLastNameKana()) + "," +
                mySQLLogic.escapeString(dto.getParentFirstNameKana()) + "," +
                mySQLLogic.escapeString(dto.getTelNumber()) + "," +
                mySQLLogic.escapeString(dto.getPhoneNumber()) + "," +
                mySQLLogic.escapeString(dto.getEmailAddress()) + "," +
                mySQLLogic.escapeString(dto.getBirthday()) + "," +
                mySQLLogic.escapeString(dto.getFamilyRelationship()) + "," +
                mySQLLogic.escapeString(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) + "," +
                mySQLLogic.escapeString(String.valueOf(EnrollmentStatus.WAITING)) + ");";

        boolean result = mySQLManager.execute(sql);
        mySQLManager.close();;
        return result;
    }
}
