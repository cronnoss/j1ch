package com.dzdz.web1ch.model;

public class PassengerData {
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private String citizenshipId;
    private String residenceId;
    private String passportNum;
    private String passportIssueCountryId;
    private String passportIssueDate;
    private String passportExpiryDate;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCitizenshipId() {
        return citizenshipId;
    }

    public String getResidenceId() {
        return residenceId;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public String getPassportIssueCountryId() {
        return passportIssueCountryId;
    }

    public String getPassportIssueDate() {
        return passportIssueDate;
    }

    public String getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public PassengerData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PassengerData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PassengerData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PassengerData withBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PassengerData withCitizenshipId(String citizenshipId) {
        this.citizenshipId = citizenshipId;
        return this;
    }

    public PassengerData withResidenceId(String residenceId) {
        this.residenceId = residenceId;
        return this;
    }

    public PassengerData withPassportNum(String passportNum) {
        this.passportNum = passportNum;
        return this;
    }

    public PassengerData withPassportIssueCountryId(String passportIssueCountryId) {
        this.passportIssueCountryId = passportIssueCountryId;
        return this;
    }

    public PassengerData withPassportIssueDate(String passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
        return this;
    }

    public PassengerData withPassportExpiryDate(String passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
        return this;
    }
}
