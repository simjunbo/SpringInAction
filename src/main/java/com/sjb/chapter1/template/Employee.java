package com.sjb.chapter1.template;

import java.math.BigDecimal;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
