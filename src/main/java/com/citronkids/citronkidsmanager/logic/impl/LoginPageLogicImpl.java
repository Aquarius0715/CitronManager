package com.citronkids.citronkidsmanager.logic.impl;

import com.citronkids.citronkidsmanager.logic.LoginPageLogic;
import com.citronkids.citronkidsmanager.model.LoginPageMdl;
import database.mysql.dao.impl.CitronUserDAOImpl;
import database.mysql.dto.CitronUserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;

public class LoginPageLogicImpl implements LoginPageLogic {
    public LoginPageLogicImpl() {
        this.loginPageMdl = null;
    }
    public LoginPageLogicImpl(CitronUserDTO citronUserDTO) {
        this.loginPageMdl = new LoginPageMdl(citronUserDTO.getUsername(), citronUserDTO.getPassword());
    }
    LoginPageMdl loginPageMdl;

    @Override
    public boolean checkAuthenticate(LoginPageMdl mdl) throws NoSuchAlgorithmException {
        if (mdl == null) {
            System.err.println("LoginPageMdl is null.");
            return false;
        }
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        if (bcpe.matches(mdl.getPassword(), citronUserDAO.loadPasswordByUsername(mdl.getUsername()))) {
            return true;
        } else {
            System.err.println("ユーザーネームが間違っているまたはパスワードが間違っています。");
            return false;
        }
    }

    CitronUserDAOImpl citronUserDAO = new CitronUserDAOImpl();
}
