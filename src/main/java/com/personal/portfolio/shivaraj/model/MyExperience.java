package com.personal.portfolio.shivaraj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "my_experience")
@Table
public class MyExperience {
    @Getter
    @Setter
    @Column(name = "job_year")
    private String jobYear;
    @Getter
    @Setter
    @Id
    @Column(name = "position")
    private String position;
    @Getter
    @Setter
    @Column(name = "organization")
    private String organization;
    @Getter
    @Setter
    @Column(name = "job_description", length = 500)
    private String jobDescription;

}
