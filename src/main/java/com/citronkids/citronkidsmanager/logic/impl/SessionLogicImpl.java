package com.citronkids.citronkidsmanager.logic.impl;

import com.citronkids.citronkidsmanager.logic.SessionLogic;
import com.citronkids.citronkidsmanager.model.SessionMdl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class SessionLogicImpl implements SessionLogic {

    public static void checkSession(HttpServletRequest request, HttpServletResponse response, String destination) throws IOException, ServletException {
        SessionMdl mdl = (SessionMdl) request.getSession().getAttribute("session");
        long currentDate = new Date().getTime();
        if (mdl == null) {
            request.getSession().setAttribute("message", "CitronKidsManagerへようこそ");
            request.getRequestDispatcher("WEB-INF/pages/jsp/login.jsp").forward(request, response);
        } else if (currentDate - mdl.getLoginDate().getTime() > 86400 * 1000) {
            request.getSession().setAttribute("message", "ログインしてから一定時間が経過したため、ログインページに遷移しました。");
            request.getRequestDispatcher("WEB-INF/pages/jsp/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/pages/jsp/" + destination).forward(request, response);
        }
    }
}
