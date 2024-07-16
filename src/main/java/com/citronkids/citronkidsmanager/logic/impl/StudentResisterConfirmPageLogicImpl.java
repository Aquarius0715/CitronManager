package com.citronkids.citronkidsmanager.logic.impl;

import com.citronkids.citronkidsmanager.logic.StudentResisterConfirmPageLogic;
import com.citronkids.citronkidsmanager.model.StudentResisterPageMdl;
import database.mysql.dao.CitronStudentAddressDAO;
import database.mysql.dao.CitronStudentDAO;
import database.mysql.dao.CitronStudentDetailDAO;
import database.mysql.dao.impl.CitronStudentAddressDAOImpl;
import database.mysql.dao.impl.CitronStudentDAOImpl;
import database.mysql.dao.impl.CitronStudentDetailDAOImpl;
import database.mysql.dto.CitronStudentAddressDTO;
import database.mysql.dto.CitronStudentDTO;
import database.mysql.dto.CitronStudentDetailDTO;

public class StudentResisterConfirmPageLogicImpl implements StudentResisterConfirmPageLogic {

    @Override
    public boolean checkResisterResult(StudentResisterPageMdl mdl) {
        CitronStudentDAO citronStudentDAO = new CitronStudentDAOImpl();
        CitronStudentDetailDAO citronStudentDetailDAO = new CitronStudentDetailDAOImpl();
        CitronStudentAddressDAO citronStudentAddressDAO = new CitronStudentAddressDAOImpl();


        CitronStudentDTO citronStudentDTO = new CitronStudentDTO(
                mdl.getStudentId(),
                mdl.getLastName(),
                mdl.getFirstName(),
                mdl.getLastNameKana(),
                mdl.getFirstNameKana(),
                mdl.getEmergencyCallNumber(),
                mdl.getEmergencyRelationship()
        );
        CitronStudentDetailDTO citronStudentDetailDTO = new CitronStudentDetailDTO(
                mdl.getStudentId(),
                mdl.getParentLastName(),
                mdl.getParentFirstName(),
                mdl.getParentLastNameKana(),
                mdl.getParentFirstNameKana(),
                mdl.getTelNumber(),
                mdl.getPhoneNumber(),
                mdl.getMailAddress(),
                mdl.getBirthday(),
                mdl.getFamilyRelationship()
        );
        CitronStudentAddressDTO citronStudentAddressDTO = new CitronStudentAddressDTO(
                mdl.getStudentId(),
                mdl.getZipCode(),
                mdl.getPrefecture(),
                mdl.getCityAndDistrict(),
                mdl.getStreet(),
                mdl.getApartmentNumber(),
                mdl.getDetail()
        );
        return citronStudentDAO.storeCitronStudent(citronStudentDTO) && citronStudentDetailDAO.storeCitronStudentDetail(citronStudentDetailDTO) && citronStudentAddressDAO.storeCitronStudentAddress(citronStudentAddressDTO);
    }
}
