package com.finalproject.medicare.entity;

public class LoginResponse {

    private String userVerified;
    private boolean AdminIs;

    public LoginResponse(){}

    public LoginResponse(String userVerified, boolean AdminIs) {
        this.userVerified = userVerified;
        this.AdminIs = AdminIs;
    }

    public String getUserVerified() {
        return userVerified;
    }

    public void setUserVerified(String userVerified) {
        this.userVerified = userVerified;
    }

    public boolean getAdminIs() {
        return AdminIs;
    }

    public void setAdminIs(boolean adminIs) {
        AdminIs = adminIs;
    }
}
