package com.citronkids.citronkidsmanager.facade.impl;

import com.citronkids.citronkidsmanager.facade.MainPageFacade;
import com.citronkids.citronkidsmanager.logic.impl.SessionLogicImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Main")
public class MainPageFacadeImpl extends HttpServlet implements MainPageFacade {
    private static final long serialVersionID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        SessionLogicImpl.checkSession(request, response, "home.jsp");
    }
}
