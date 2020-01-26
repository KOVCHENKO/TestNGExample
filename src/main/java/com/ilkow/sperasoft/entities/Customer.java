package com.ilkow.sperasoft.entities;

public class Customer {

    private String title;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String dayOfBirth;

    private String monthOfBirth;

    private String yearOfBirth;

    private String firstNameAddress;

    private String lastNameAddress;

    private String company;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String postCode;

    private String country;

    private String additionalInformation;

    private String homePhone;

    private String mobilePhone;

    private String addressAlias;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        int uniqueNumber = (int) (Math.random() * 100000);
        this.email = "testemail" + "_" + uniqueNumber + "@mail.com";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstNameAddress() {
        return firstNameAddress;
    }

    public void setFirstNameAddress(String firstNameAddress) {
        this.firstNameAddress = firstNameAddress;
    }

    public String getLastNameAddress() {
        return lastNameAddress;
    }

    public void setLastNameAddress(String lastNameAddress) {
        this.lastNameAddress = lastNameAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
    }

    public String[] toArray() {
        return new String[] {
            title,
            firstName,
            lastName,
            email,
            password,
            dayOfBirth,
            monthOfBirth,
            yearOfBirth,
            firstNameAddress,
            lastNameAddress,
            company,
            address1,
            address2,
            city,
            state,
            postCode,
            country,
            additionalInformation,
            homePhone,
            mobilePhone,
            addressAlias

        };
    }
}
