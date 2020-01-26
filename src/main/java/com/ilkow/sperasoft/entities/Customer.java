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

    private CustomerAddress customerAddress;

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

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Customer createValid() {
        this.setFirstName("TestFirstName");
        this.setLastName("TestLastName");
        this.setPassword("test_password");

        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setHomePhone("12019424132");
        customerAddress.setHomePhone("12019424132");
        customerAddress.setAddress1("Main st., Company");
        customerAddress.setCity("Albuquerque");
        customerAddress.setPostCode("00000");
        customerAddress.setState("test_state");
        this.setCustomerAddress(customerAddress);

        return this;
    }

    public Customer createInvalid() {
        this.setFirstName("test_first_name");
        this.setLastName("test_last_name");
        this.setPassword("test_password");
        return this;
    }
}
