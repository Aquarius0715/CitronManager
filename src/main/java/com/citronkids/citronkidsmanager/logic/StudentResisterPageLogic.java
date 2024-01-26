package com.citronkids.citronkidsmanager.logic;

import com.citronkids.citronkidsmanager.logic.impl.StudentResisterPageLogicImpl;
import com.citronkids.citronkidsmanager.model.StudentResisterPageMdl;

import java.util.ArrayList;
import java.util.HashMap;

public interface StudentResisterPageLogic {
    StudentResisterPageLogicImpl.RetObj checkMembers(StudentResisterPageMdl mdl);
}
