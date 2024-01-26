package database.mysql.dto;

import struct.EnrollmentStatus;

import java.util.Date;

public class CitronStudentDTO {

    private int studentId;
    private String lastName;
    private String firstName;
    private String lastNameKana;
    private String firstNameKana;
    private String emergencyCallNumber;
    private String emergencyRelationship;
    private String parentLastName;
    private String parentFirstName;
    private String parentLastNameKana;
    private String parentFirstNameKana;
    private String telNumber;
    private String phoneNumber;
    private String emailAddress;
    private String birthday;
    private String familyRelationship;
    private Date enrollmentDate;
    private EnrollmentStatus enrollmentStatus;
    private String zioCode;
    private String prefecture;
    private String city;
    private String street;
    private String apartmentNumber;
    private String detail;

    public CitronStudentDTO() {}

    public CitronStudentDTO(String lastName, String firstName, String lastNameKana, String firstNameKana, String emergencyCallNumber, String emergencyRelationship, String parentLastName, String parentFirstName, String parentLastNameKana, String parentFirstNameKana, String telNumber, String phoneNumber, String emailAddress, String birthday, String familyRelationship, Date enrollmentDate, EnrollmentStatus enrollmentStatus, String zioCode, String prefecture, String city, String street, String apartmentNumber, String detail) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.lastNameKana = lastNameKana;
        this.firstNameKana = firstNameKana;
        this.emergencyCallNumber = emergencyCallNumber;
        this.emergencyRelationship = emergencyRelationship;
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
        this.zioCode = zioCode;
        this.prefecture = prefecture;
        this.city = city;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.detail = detail;
    }

    public int getStudentId() {
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

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public String getZioCode() {
        return zioCode;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setStudentId(int studentId) {
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

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public void setZioCode(String zioCode) {
        this.zioCode = zioCode;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
