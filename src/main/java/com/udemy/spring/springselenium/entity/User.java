package com.udemy.spring.springselenium.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@Entity
public class User {

    @Id
    @Column(unique = true)
    private Integer id;

    private String fromCountry;

    private String toCountry;

    private Date dob;

    private String firstName;

    private String lastName;

    @Column(name = "customer_email")
    private String email;

    private String phone;

    private String comments;
}
