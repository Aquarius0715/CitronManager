package com.citronkids.citronkidsmanager.model;

import java.io.Serializable;
import java.util.Date;

public class SessionMdl implements Serializable {
    private String username;
    private Date loginDate;

    public SessionMdl(String username, Date loginDate) {
        this.username = username;
        this.loginDate = loginDate;
    }
    public SessionMdl() {}

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
    public Date getLoginDate() {
        return loginDate;
    }
}
