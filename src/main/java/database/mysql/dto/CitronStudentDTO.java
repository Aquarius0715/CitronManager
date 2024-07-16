package database.mysql.dto;

import struct.EnrollmentStatus;

import java.util.Date;

public class CitronStudentDTO {

    private String studentId;
    private String lastName;
    private String firstName;
    private String lastNameKana;
    private String firstNameKana;
    private String emergencyCallNumber;
    private String emergencyRelationship;
    public CitronStudentDTO() {}

    public CitronStudentDTO(String studentId, String lastName, String firstName, String lastNameKana, String firstNameKana, String emergencyCallNumber, String emergencyRelationship) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.lastNameKana = lastNameKana;
        this.firstNameKana = firstNameKana;
        this.emergencyCallNumber = emergencyCallNumber;
        this.emergencyRelationship = emergencyRelationship;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public String getFirstNameKana() {
        return firstNameKana;
    }

    public String getEmergencyCallNumber() {
        return emergencyCallNumber;
    }

    public String getEmergencyRelationship() {
        return emergencyRelationship;
    }



    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    public void setEmergencyCallNumber(String emergencyCallNumber) {
        this.emergencyCallNumber = emergencyCallNumber;
    }

    public void setEmergencyRelationship(String emergencyRelationship) {
        this.emergencyRelationship = emergencyRelationship;
    }
}
