package com.personal.portfolio.shivaraj.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Entity(name = "personal_info")
@Table
public class PersonalInfo {


    @Column(name = "full_name")
    private String fullName;
    @Max(value =58, message = "age should be more than 58")
    @Min(value = 18, message = "age should not be less than 18")
    @Column(name = "age")
    private int age;
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "address", length = 500)
    private String address;
    @Column(name = "cv_url", length = 500)
    private String cvUrl;
    @Column(name="cv_download_icon")
    private String cvDownloadIcon;

    @Column(name = "description", length = 500)
    @Size(max = 500, message = "Description should not exceed 500 characters")
    private String description;
    @Column(name = "twitter_link", length = 500)
    private String twitterLink;
    @Column(name = "linkedin_link", length = 500)
    private String linkedinLink;
    @Column(name = "researchgate_link", length = 500)
    private String researchgateLink;
    @Column(name = "github_link", length = 500)
    private String githubLink;

    @Column(name = "years_of_experience")
    private int yearsOfExperience;
    @Column(name = "happy_client")
    private int happyClient;
    @Column(name = "projects_done")
    private int projectsDone;
    @Column(name = "number_of_awards")
    private int numberOfAwards;



}
