package com.dzdz.web1ch.model;

public class PassengerData {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String birthDate;
    private final String citizenshipId;
    private final String residenceId;
    private final String passportNum;
    private final String passportIssueCountryId;
    private final String passportIssueDate;
    private final String passportExpiryDate;


    public PassengerData(String firstName, String lastName, String middleName, String birthDate, String citizenshipId, String residenceId, String passportNum, String passportIssueCountryId, String passportIssueDate, String passportExpiryDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.citizenshipId = citizenshipId;
        this.residenceId = residenceId;
        this.passportNum = passportNum;
        this.passportIssueCountryId = passportIssueCountryId;
        this.passportIssueDate = passportIssueDate;
        this.passportExpiryDate = passportExpiryDate;
    }

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
}
