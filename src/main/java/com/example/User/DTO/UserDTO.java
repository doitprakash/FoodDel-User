package com.example.User.DTO;

public class UserDTO {
    private String userId;
    private String name;
    private String address;
    private String emailId;
    private String phoneNo;
    private String username;

    public UserDTO() {

    }
    public UserDTO(String userId, String name, String address, String emailId, String phoneNo, String username) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
