package database.mysql.dto;

public class CitronStudentAddressDTO {
    private String  studentId;
    private String zipCode;
    private String prefecture;
    private String city;
    private String street;
    private String apartmentNumber;
    private String detail;

    public CitronStudentAddressDTO() {
    }

    public CitronStudentAddressDTO(String studentId, String zipCode, String prefecture, String city, String street, String apartmentNumber, String detail) {
        this.studentId = studentId;
        this.zipCode = zipCode;
        this.prefecture = prefecture;
        this.city = city;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.detail = detail;
    }

    public String  getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
