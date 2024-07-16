package com.citronkids.citronkidsmanager.model;

import java.io.Serializable;
import java.util.Date;

public class StudentResisterPageMdl implements Serializable {
    private static final long serialVersionUID = 1L;
    private String studentId = "";
    private String studentLastName = "";
    private String studentFirstName = "";
    private String studentLastNameKana = "";
    private String studentFirstNameKana = "";
    private String mailAddress = "";
    private String telNumber = "";
    private String phoneNumber = "";
    private String emergencyCallNumber = "";
    private String emergencyRelationship = "";
    private String birthday = "";
    private String parentLastName = "";
    private String parentFirstName = "";
    private String parentLastNameKana = "";
    private String parentFirstNameKana = "";
    private String familyRelationship = "";
    private String zipCode = "";
    private String prefecture = "";
    private String cityAndDistrict = "";
    private String street = "";
    private String apartmentNumber = "";
    private String detail = "";

    public String getStudentId() {
        return studentId;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getEmergencyCallNumber() {
        return emergencyCallNumber;
    }
    public String getFirstName() {
        return studentFirstName;
    }
    public String getFirstNameKana() {
        return studentFirstNameKana;
    }
    public String getLastName() {
        return studentLastName;
    }
    public String getLastNameKana() {
        return studentLastNameKana;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setEmergencyCallNumber(String emergencyCallNumber) {
        this.emergencyCallNumber = emergencyCallNumber;
    }
    public void setFirstName(String firstName) {
        this.studentFirstName = firstName;
    }
    public void setFirstNameKana(String firstNameKana) {
        this.studentFirstNameKana = firstNameKana;
    }
    public void setLastName(String lastName) {
        this.studentLastName = lastName;
    }
    public void setLastNameKana(String lastNameKana) {
        this.studentLastNameKana = lastNameKana;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastNameKana() {
        return studentLastNameKana;
    }

    public String getStudentFirstNameKana() {
        return studentFirstNameKana;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public String getFamilyRelationship() {
        return familyRelationship;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public String getCityAndDistrict() {
        return cityAndDistrict;
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

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public void setStudentLastNameKana(String studentLastNameKana) {
        this.studentLastNameKana = studentLastNameKana;
    }

    public void setStudentFirstNameKana(String studentFirstNameKana) {
        this.studentFirstNameKana = studentFirstNameKana;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public void setFamilyRelationship(String familyRelationship) {
        this.familyRelationship = familyRelationship;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public void setCityAndDistrict(String cityAndDistrict) {
        this.cityAndDistrict = cityAndDistrict;
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
