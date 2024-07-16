package database.mysql.dao.impl;

import database.mysql.dao.CitronStudentAddressDAO;
import database.mysql.dto.CitronStudentAddressDTO;
import database.mysql.logic.impl.MySQLLogicImpl;
import database.mysql.main.impl.MySQLManagerImpl;

public class CitronStudentAddressDAOImpl implements CitronStudentAddressDAO {

    MySQLLogicImpl mySQLLogic = new MySQLLogicImpl();

    @Override
    public boolean storeCitronStudentAddress(CitronStudentAddressDTO dto) {
        MySQLManagerImpl mySQLManager = new MySQLManagerImpl("storeCitronStudentAddress");
        String sql = "INSERT INTO citron_students_address(" +
                "student_id," +
                "zip_code," +
                "prefecture," +
                "city," +
                "street," +
                "apartment_number," +
                "detail" +
                ") VALUES (" +
                mySQLLogic.escapeString(dto.getStudentId()) + "," +
                mySQLLogic.escapeString(dto.getZipCode()) + "," +
                mySQLLogic.escapeString(dto.getPrefecture()) + "," +
                mySQLLogic.escapeString(dto.getCity()) + "," +
                mySQLLogic.escapeString(dto.getStreet()) + "," +
                mySQLLogic.escapeString(dto.getApartmentNumber()) + "," +
                mySQLLogic.escapeString(dto.getDetail()) + ");";

        boolean result = mySQLManager.execute(sql);
        mySQLManager.close();
        return result;
    }
}
