package com.citronkids.citronkidsmanager.facade.impl;

import com.citronkids.citronkidsmanager.facade.StudentResisterConfirmPageFacade;
import com.citronkids.citronkidsmanager.logic.StudentResisterConfirmPageLogic;
import com.citronkids.citronkidsmanager.logic.impl.SessionLogicImpl;
import com.citronkids.citronkidsmanager.logic.impl.StudentResisterConfirmPageLogicImpl;
import com.citronkids.citronkidsmanager.model.StudentResisterConfirmPageMdl;
import com.citronkids.citronkidsmanager.model.StudentResisterPageMdl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;


@WebServlet("/StudentResisterConfirm")
public class StudentResisterConfirmPageFacadeImpl extends HttpServlet implements StudentResisterConfirmPageFacade {
    private static final long serialVersionUID = 1L;
    private final StudentResisterConfirmPageLogic logic = new StudentResisterConfirmPageLogicImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=Shift_JIS");
        SessionLogicImpl.checkSession(request, response, "studentResisterConfirmPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentResisterPageMdl mdl;
        if (request.getParameter("resister") != null) {
            //TODO DBにデータを登録
            if (request.getSession().getAttribute("model") != null) {
                mdl = (StudentResisterPageMdl) request.getSession().getAttribute("model");
                mdl.setStudentId(UUID.randomUUID().toString());
                request.getSession().removeAttribute("model");
            } else {
                request.getRequestDispatcher("WEB-INF/pages/jsp/studentResisterFailedPage.jsp").forward(request, response);
                return;
            }
            if (!logic.checkResisterResult(mdl)) {
                request.getRequestDispatcher("WEB-INF/pages/jsp/studentResisterFailedPage.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/pages/jsp/studentResisterCompletePage.jsp").forward(request, response);
            }
        }
        else if (request.getParameter("fix") != null) {
            request.getRequestDispatcher("WEB-INF/pages/jsp/studentResisterPage.jsp").forward(request, response);
        }
    }
}
