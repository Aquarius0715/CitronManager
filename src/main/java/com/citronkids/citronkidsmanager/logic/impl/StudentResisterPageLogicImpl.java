package com.citronkids.citronkidsmanager.logic.impl;

import com.citronkids.citronkidsmanager.logic.StudentResisterPageLogic;
import com.citronkids.citronkidsmanager.model.StudentResisterPageMdl;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentResisterPageLogicImpl implements StudentResisterPageLogic {

    public static class RetObj implements Serializable {
        private static final long serialVersionUID = 1L;
        public RetObj(ArrayList<String> errorMessages, StudentResisterPageMdl mdl) {
            this.errorMessages = errorMessages;
            this.mdl = mdl;
        }
        ArrayList<String> errorMessages;
        StudentResisterPageMdl mdl;

        public ArrayList<String> getErrorMessages() {
            return errorMessages;
        }
        public StudentResisterPageMdl getMdl() {
            return mdl;
        }
    }

    @Override
    public RetObj checkMembers(StudentResisterPageMdl mdl) {
        ArrayList<String> errorMessages = new ArrayList<>();
        if (mdl.getStudentLastName().isEmpty()) {
            errorMessages.add("生徒苗字が空白です。");
        }
        else if (mdl.getStudentLastName().length() > 50) {
            errorMessages.add("生徒苗字が長すぎます。");
            mdl.setStudentLastName("");
        }
        if (mdl.getStudentFirstName().isEmpty()) {
            errorMessages.add("生徒名前が空白です。");
        }
        else if (mdl.getStudentFirstName().length() > 50) {
            errorMessages.add("生徒名前が長すぎます。");
            mdl.setStudentFirstName("");
        }
        if (mdl.getStudentLastNameKana().isEmpty()) {
            errorMessages.add("生徒苗字カナが空白です。");
        }
        else if (mdl.getStudentLastNameKana().length() > 50) {
            errorMessages.add("生徒苗字カナが長すぎます。");
            mdl.setStudentLastNameKana("");
        } else if (isKana(mdl.getStudentLastNameKana())) {
            errorMessages.add("生徒苗字カナを正しく入力してください。");
            mdl.setStudentLastNameKana("");
        } else {
            mdl.setStudentLastNameKana(
                    hiraganaToKatakana(mdl.getStudentLastNameKana())
            );
        }
        if (mdl.getStudentFirstNameKana().isEmpty()) {
            errorMessages.add("生徒名前カナが空白です。");
        }
        else if (mdl.getStudentFirstNameKana().length() > 50) {
            errorMessages.add("生徒名前カナが長すぎます。");
            mdl.setStudentFirstNameKana("");
        } else if (isKana(mdl.getStudentFirstNameKana())) {
            errorMessages.add("生徒名前カナを正しく入力してください。");
            mdl.setStudentFirstNameKana("");
        } else {
            mdl.setStudentFirstNameKana(
                    hiraganaToKatakana(mdl.getStudentFirstNameKana())
            );
        }
        if (!mdl.getMailAddress().isEmpty()) {
            if (!EmailValidator.getInstance().isValid(mdl.getMailAddress())) {
                errorMessages.add("有効なメールアドレスを入力してください。");
                mdl.setMailAddress("");
            }
            else if (mdl.getMailAddress().length() > 254) {
                errorMessages.add("メールアドレスが長すぎます。");
                mdl.setMailAddress("");
            }
        }
        if (!mdl.getTelNumber().isEmpty()) {
            if (checkTelNumber(mdl.getTelNumber())) {
                errorMessages.add("有効な固定電話番号を入力してください。");
                mdl.setTelNumber("");
            } else {
                mdl.setTelNumber(
                        removeSymbol(mdl.getTelNumber())
                );
            }
        }
        if (!mdl.getPhoneNumber().isEmpty()) {
            if (checkPhoneNumber(mdl.getPhoneNumber())) {
                errorMessages.add("有効な携帯電話番号を入力してください。");
                mdl.setPhoneNumber("");
            } else {
                mdl.setPhoneNumber(
                        removeSymbol(mdl.getPhoneNumber())
                );
            }
        }
        if (mdl.getEmergencyCallNumber().isEmpty()) {
            errorMessages.add("緊急連絡先が空白です。");
        } else if (checkTelNumber(mdl.getEmergencyCallNumber())
                || checkPhoneNumber(mdl.getEmergencyCallNumber())) {
            errorMessages.add("有効な電話番号を入力してください。");
            mdl.setEmergencyCallNumber("");
        } else {
            mdl.setEmergencyCallNumber(
                    removeSymbol(mdl.getEmergencyCallNumber())
            );
        }
        if (mdl.getEmergencyRelationship().isEmpty()) {
            errorMessages.add("緊急連絡先続柄が空白です。");
        } else if (mdl.getEmergencyRelationship().length() > 20) {
            errorMessages.add("緊急連絡先続柄が長すぎます。");
            mdl.setEmergencyRelationship("");
        }
        if (mdl.getBirthday().isEmpty()) {
            errorMessages.add("生年月日が空白です。");
        }
        if (mdl.getBirthday() == null) {
            errorMessages.add("意図しない日付または日付が空白です。");
        }
        if (mdl.getParentLastName().isEmpty()) {
            errorMessages.add("保護者苗字が空白です。");
        } else if (mdl.getParentLastName().length() > 50) {
            errorMessages.add("保護者苗字が長すぎます。");
            mdl.setParentLastName("");
        }
        if (mdl.getParentFirstName().isEmpty()) {
            errorMessages.add("保護者名前が空白です。");
        } else if (mdl.getParentFirstName().length() > 50) {
            errorMessages.add("保護者名前が長すぎます。");
            mdl.setParentFirstName("");
        }
        if (mdl.getParentLastNameKana().isEmpty()) {
            errorMessages.add("保護者苗字カナが空白です。");
        } else if (mdl.getParentLastNameKana().length() > 50) {
            errorMessages.add("保護者苗字カナが長すぎます。");
            mdl.setParentLastNameKana("");
        } else if (isKana(mdl.getParentLastNameKana())) {
            errorMessages.add("保護者苗字カナを正しく入力してください。");
            mdl.setParentLastNameKana("");
        } else {
            mdl.setParentLastNameKana(
                    hiraganaToKatakana(mdl.getParentLastName())
            );
        }
        if (mdl.getParentFirstNameKana().isEmpty()) {
            errorMessages.add("保護者名前カナが空白です。");
        } else if (mdl.getParentFirstNameKana().length() > 50) {
            errorMessages.add("保護者名前カナが長すぎます。");
            mdl.setParentFirstNameKana("");
        } else if (isKana(mdl.getParentFirstNameKana())) {
            errorMessages.add("保護者名前カナを正しく入力してください。");
            mdl.setParentFirstNameKana("");
        } else {
            mdl.setParentFirstNameKana(
                    hiraganaToKatakana(mdl.getParentFirstNameKana())
            );
        }
        if (mdl.getFamilyRelationship().isEmpty()) {
            errorMessages.add("続柄が空白です。");
        } else if (mdl.getFamilyRelationship().length() > 20) {
            errorMessages.add("続柄が長すぎます。");
            mdl.setFamilyRelationship("");
        }
        if (mdl.getZipCode().isEmpty()) {
            errorMessages.add("郵便番号が空白です。");
        } else if (checkZipCode(mdl.getZipCode())) {
            errorMessages.add("有効な郵便番号を入力してください。");
            mdl.setZipCode("");
        } else {
            mdl.setZipCode(
                    removeSymbol(mdl.getZipCode())
            );
        }
        if (mdl.getPrefecture().isEmpty()) {
            errorMessages.add("都道府県が空白です。");
        } else if (mdl.getPrefecture().length() > 10) {
            errorMessages.add("都道府県が長すぎます。");
            mdl.setPrefecture("");
        }
        if (mdl.getCityAndDistrict().isEmpty()) {
            errorMessages.add("市区町村が空白です。");
        } else if (mdl.getCityAndDistrict().length() > 30) {
            errorMessages.add("市区町村が長すぎます。");
            mdl.setCityAndDistrict("");
        }
        if (mdl.getStreet().isEmpty()) {
            errorMessages.add("番地が空白です。");
        } else if (mdl.getStreet().length() > 128) {
            errorMessages.add("番地が長すぎます。");
            mdl.setStreet("");
        }
        if (mdl.getApartmentNumber().length() > 120) {
            errorMessages.add("部屋番号が長すぎます。");
            mdl.setApartmentNumber("");
        }
        if (mdl.getDetail().length() > 65535) {
            errorMessages.add("詳細が長すぎます。");
            mdl.setDetail("");
        }
        return new RetObj(errorMessages, mdl);
    }

    private boolean checkPhoneNumber(String telNumber) {
        Pattern pattern = Pattern.compile("^(070|080|090)\\d{4}\\d{4}$");
        Matcher matcher = pattern.matcher(removeSymbol(telNumber));
        return !matcher.find();
    }

    private boolean checkTelNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^0\\d{9,10}$");
        Matcher matcher = pattern.matcher(removeSymbol(phoneNumber));
        return !matcher.find();
    }

    private boolean checkZipCode(String zipCode) {
        Pattern pattern = Pattern.compile("^[0-9]{7}$");
        Matcher matcher = pattern.matcher(removeSymbol(zipCode));
        return !matcher.find();
    }
    private String removeSymbol(String number) {
        return number.replaceAll("-", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll(" ", "");
    }

    private String hiraganaToKatakana(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c >= 'ぁ' && c <= 'ん') {
                sb.setCharAt(i, (char)(c - 'ぁ' + 'ァ'));
            }
        }
        return sb.toString();
    }
    private boolean isKana(String value) {
        Pattern pattern = Pattern.compile("^[ァ-ヴー]+$");
        Matcher matcher = pattern.matcher(hiraganaToKatakana(value));
        return !matcher.find();
    }
}
