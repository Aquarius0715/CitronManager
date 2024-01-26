package com.citronkids.citronkidsmanager.facade.impl;

import com.citronkids.citronkidsmanager.facade.StudentResisterConfirmPage;
import com.citronkids.citronkidsmanager.logic.impl.SessionLogicImpl;
import com.citronkids.citronkidsmanager.model.StudentResisterPageMdl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/StudentResisterConfirm")
public class StudentResisterConfirmPageImpl extends HttpServlet implements StudentResisterConfirmPage {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=Shift_JIS");
        SessionLogicImpl.checkSession(request, response, "studentResisterConfirmPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("resister") != null) {
            //TODO DBにデータを登録

        }
        else if (request.getParameter("fix") != null) {
            request.getRequestDispatcher("WEB-INF/pages/jsp/studentResisterPage.jsp").forward(request, response);
        }
    }
}
