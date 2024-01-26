package database.mysql.dto;

import java.util.Date;

public class CitronUserDTO {
    public CitronUserDTO() {}
    public CitronUserDTO(String username, String password, Date registration_date) {
        this.password = password;
        this.username = username;
        this.registration_date = registration_date;
    }
    public CitronUserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    private String username;
    private String password;
    private Date registration_date;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getRegistration_date() {
        return registration_date;
    }
}
