package com.citronkids.citronkidsmanager.facade.impl;

import com.citronkids.citronkidsmanager.facade.StudentResisterPageFacade;
import com.citronkids.citronkidsmanager.logic.impl.SessionLogicImpl;
import com.citronkids.citronkidsmanager.logic.impl.StudentResisterPageLogicImpl;
import com.citronkids.citronkidsmanager.model.StudentResisterPageMdl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/StudentResister")
public class StudentResisterPageFacadeImpl extends HttpServlet implements StudentResisterPageFacade {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=Shift_JIS");
        SessionLogicImpl.checkSession(request, response, "studentResisterPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("Shift_JIS");
        StudentResisterPageMdl mdl = new StudentResisterPageMdl();
        mdl.setStudentLastName(request.getParameter("studentLastName"));
        mdl.setStudentFirstName(request.getParameter("studentFirstName"));
        mdl.setStudentLastNameKana(request.getParameter("studentLastNameKana"));
        mdl.setStudentFirstNameKana(request.getParameter("studentFirstNameKana"));
        mdl.setMailAddress(request.getParameter("emailAddress"));
        mdl.setTelNumber(request.getParameter("telNumber"));
        mdl.setPhoneNumber(request.getParameter("phoneNumber"));
        mdl.setEmergencyCallNumber(request.getParameter("emergencyNumber"));
        mdl.setEmergencyRelationship(request.getParameter("emergencyRelationship"));
        mdl.setBirthday(request.getParameter("birthday"));
        mdl.setParentLastName(request.getParameter("parentLastName"));
        mdl.setParentFirstName(request.getParameter("parentFirstName"));
        mdl.setParentLastNameKana(request.getParameter("parentLastNameKana"));
        mdl.setParentFirstNameKana(request.getParameter("parentFirstNameKana"));
        mdl.setFamilyRelationship(request.getParameter("familyRelationship"));
        mdl.setZipCode(request.getParameter("zipCode"));
        mdl.setPrefecture(request.getParameter("prefecture"));
        mdl.setCityAndDistrict(request.getParameter("cityAndDistrict"));
        mdl.setStreet(request.getParameter("street"));
        mdl.setApartmentNumber(request.getParameter("apartmentNumber"));
        mdl.setDetail(request.getParameter("detail"));

        StudentResisterPageLogicImpl.RetObj returnObj = logic.checkMembers(mdl);

        ArrayList<String> errorMessages = returnObj.getErrorMessages();
        StudentResisterPageMdl normalizedModel = returnObj.getMdl();
        request.setAttribute("errorMessages", errorMessages);

        request.getSession().setAttribute("model", normalizedModel);

        if (errorMessages.isEmpty()) {
            request.getRequestDispatcher("WEB-INF/pages/jsp/studentResisterConfirmPage.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/pages/jsp/studentResisterPage.jsp").forward(request, response);
        }
    }

    StudentResisterPageLogicImpl logic = new StudentResisterPageLogicImpl();

}
