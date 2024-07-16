package database.mysql.dto;

import struct.EnrollmentStatus;

public class CitronStudentDetailDTO {
    private String student_id;
    private String parentLastName;
    private String parentFirstName;
    private String parentLastNameKana;
    private String parentFirstNameKana;
    private String telNumber;
    private String phoneNumber;
    private String emailAddress;
    private String birthday;
    private String familyRelationship;
    private String enrollmentDate;
    private EnrollmentStatus enrollmentStatus;

    public CitronStudentDetailDTO() {}

    public CitronStudentDetailDTO(String parentLastName, String parentFirstName, String parentLastNameKana, String parentFirstNameKana, String telNumber, String phoneNumber, String emailAddress, String birthday, String familyRelationship, String enrollmentDate, EnrollmentStatus enrollmentStatus) {
        this.parentLastName = parentLastName;
        this.parentFirstName = parentFirstName;
        this.parentLastNameKana = parentLastNameKana;
        this.parentFirstNameKana = parentFirstNameKana;
        this.telNumber = telNumber;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthday = birthday;
        this.familyRelationship = familyRelationship;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentStatus = enrollmentStatus;
    }
    public CitronStudentDetailDTO(String studentId, String parentLastName, String parentFirstName, String parentLastNameKana, String parentFirstNameKana, String telNumber, String phoneNumber, String emailAddress, String birthday, String familyRelationship) {
        this.student_id = studentId;
        this.parentLastName = parentLastName;
        this.parentFirstName = parentFirstName;
        this.parentLastNameKana = parentLastNameKana;
        this.parentFirstNameKana = parentFirstNameKana;
        this.telNumber = telNumber;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.birthday = birthday;
        this.familyRelationship = familyRelationship;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public String getParentLastNameKana() {
        return parentLastNameKana;
    }

    public String getParentFirstNameKana() {
        return parentFirstNameKana;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getFamilyRelationship() {
        return familyRelationship;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public void setParentLastNameKana(String parentLastNameKana) {
        this.parentLastNameKana = parentLastNameKana;
    }

    public void setParentFirstNameKana(String parentFirstNameKana) {
        this.parentFirstNameKana = parentFirstNameKana;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setFamilyRelationship(String familyRelationship) {
        this.familyRelationship = familyRelationship;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
}
