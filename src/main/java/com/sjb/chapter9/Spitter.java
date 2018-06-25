package com.sjb.chapter9;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

    private Long id;

    @NotNull(message = "username cannot be null")
    @Size(min = 5, max = 16, message = "username must be between 5 and 16 characters long")
    private String username;

    @NotNull(message = "password cannot be null")
    @Size(min = 5, max = 25, message = "password must be between 5 and 25 characters long")
    private String password;

    @NotNull(message = "firstName cannot be null")
    @Size(min = 2, max = 30, message = "firstName must be between 2 and 30 characters long")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @Size(min = 2, max = 30, message = "lastName must be between 2 and 30 characters long")
    private String lastName;

    @NotNull(message = "email cannot be null")
    @Size(min = 2, max = 30, message = "email must be between 2 and 30 characters long")
    private String email;

    public Spitter() {
    }

    public Spitter(String userName, String password, String firstName, String lastName, String email) {
        this(null, userName, password, firstName, lastName, email);
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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