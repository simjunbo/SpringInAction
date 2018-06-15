package com.sjb.chapter5.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spitter {

    private Long id;

    @NotNull(message = "userName cannot be null")
    @Size(min = 5, max = 16, message = "Username must be between 5 and 16 characters long")
    private String userName;

    @NotNull(message = "password cannot be null")
    @Size(min = 5, max = 25, message = "Username must be between 5 and 25 characters long")
    private String password;

    @NotNull(message = "firstName cannot be null")
    @Size(min = 2, max = 30, message = "Username must be between 2 and 30 characters long")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @Size(min = 2, max = 30, message = "Username must be between 2 and 30 characters long")
    private String lastName;

    public Spitter() {
    }

    public Spitter(String userName, String password, String firstName, String lastName) {
        this(null, userName, password, firstName, lastName);
    }

    public Spitter(Long id, String userName, String password, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}