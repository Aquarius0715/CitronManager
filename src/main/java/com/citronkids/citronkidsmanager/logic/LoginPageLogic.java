package com.citronkids.citronkidsmanager.logic;

import com.citronkids.citronkidsmanager.model.LoginPageMdl;

import java.security.NoSuchAlgorithmException;

public interface LoginPageLogic {
    public boolean checkAuthenticate(LoginPageMdl mdl) throws NoSuchAlgorithmException;
}
