/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class RegistrationInsertErr implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatch;
    private String fullnameLengthErr;
    private String usernameIsExist;

    public RegistrationInsertErr() {
    }

    public RegistrationInsertErr(String usernameLengthErr, String passwordLengthErr, String confirmNotMatch, String fullnameLengthErr, String usernameIsExist) {
        this.usernameLengthErr = usernameLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.confirmNotMatch = confirmNotMatch;
        this.fullnameLengthErr = fullnameLengthErr;
        this.usernameIsExist = usernameIsExist;
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    public String getUsernameIsExist() {
        return usernameIsExist;
    }

    public void setUsernameIsExist(String usernameIsExist) {
        this.usernameIsExist = usernameIsExist;
    }
    
}

