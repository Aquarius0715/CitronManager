package com.citronkids.citronkidsmanager.facade.impl;

import com.citronkids.citronkidsmanager.facade.IndexPageFacade;
import com.citronkids.citronkidsmanager.logic.impl.SessionLogicImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class IndexPageFacadeImpl extends HttpServlet implements IndexPageFacade {
    private static final long serialVersionID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionLogicImpl.checkSession(request, response, "home.jsp");
    }
}
