package com.personal.portfolio.shivaraj.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity(name = "contact_me")
@Table
public class MyContact {
    @NotEmpty(message = "address should not be empty")
    @Column(name = "full_address")
    private String fullAddress;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Id
    @NotEmpty(message = "Email address should not be empty")
    @Column(name = "email_address")
    @Email(message = "Email should be valid")
    private String emailAddress;
    @Column(name = "follow_me")
    private String followMe;

}
