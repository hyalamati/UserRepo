package com.encodeURLApp.UserDataService.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigInteger;
import java.util.Date;

@Document
public class User {
    @Id
    private BigInteger userId;
    @NotNull
    @Size(min = 2, message = "User Name should contain atleast 2 characters")
    private String userName;
    @NotNull(message = "The email address is required")
    @Email(message = "Email should be valid")
    private String email;
    private Date creationDate = new Date();
    public User(){

    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
