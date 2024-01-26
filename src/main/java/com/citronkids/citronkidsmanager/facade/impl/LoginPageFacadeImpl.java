package com.citronkids.citronkidsmanager.facade.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.citronkids.citronkidsmanager.facade.LoginPageFacade;
import com.citronkids.citronkidsmanager.logic.impl.LoginPageLogicImpl;
import com.citronkids.citronkidsmanager.logic.impl.SessionLogicImpl;
import com.citronkids.citronkidsmanager.model.LoginPageMdl;
import com.citronkids.citronkidsmanager.model.SessionMdl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/Login")
public class LoginPageFacadeImpl extends HttpServlet implements LoginPageFacade {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionLogicImpl.checkSession(request, response, "home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("Shift_JIS");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        LoginPageMdl loginPageMdl = new LoginPageMdl(username, password);

        LoginPageLogicImpl loginPageLogic = new LoginPageLogicImpl();
        boolean canLogin = false;
        try {
            canLogin = loginPageLogic.checkAuthenticate(loginPageMdl);
        } catch (NoSuchAlgorithmException e) {
            e.fillInStackTrace();
        }
        if (canLogin) {
            request.getSession().setAttribute("session", new SessionMdl(username, new Date()));
            response.sendRedirect(request.getContextPath() + "/Main");
            //request.getRequestDispatcher("WEB-INF/pages/jsp/home.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("message", "認証に失敗しました。ユーザーネームとパスワードを確認してください。");
            //request.getRequestDispatcher("WEB-INF/pages/jsp/login.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    }
}