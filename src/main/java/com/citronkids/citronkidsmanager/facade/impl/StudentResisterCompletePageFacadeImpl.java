package com.citronkids.citronkidsmanager.facade.impl;

import com.citronkids.citronkidsmanager.facade.StudentResisterCompletePageFacade;
import com.citronkids.citronkidsmanager.logic.impl.SessionLogicImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/StudentResisterComplete")
public class StudentResisterCompletePageFacadeImpl extends HttpServlet implements StudentResisterCompletePageFacade {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=Shift_JIS");
        SessionLogicImpl.checkSession(request, response, "studentResisterFailedPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("returnMenu") != null) {
            request.getRequestDispatcher("WEB-INF/pages/jsp/home.jsp").forward(request, response);
        } else if (request.getParameter("returnResister") != null) {
            request.getRequestDispatcher("WEB-INF/pages/jsp/studentResisterPage.jsp").forward(request, response);
        }
    }
}
