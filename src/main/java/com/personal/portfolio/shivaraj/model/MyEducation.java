package com.personal.portfolio.shivaraj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "my_education")
@Table
public class MyEducation {
    @Getter
    @Setter
    @Column(name = "year")
    private String year;
    @Getter
    @Setter
    @Id
    @Column(name = "degree_name")
    private String degreeName;
    @Getter
    @Setter
    @Column(name = "university")
    private String university;
    @Getter
    @Setter
    @Column(name = "education_description", length = 500)
    private String educationDescription;
}
