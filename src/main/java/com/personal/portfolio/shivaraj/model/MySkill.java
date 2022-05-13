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
@Entity(name = "my_skill")
@Table
public class MySkill {
    @Getter
    @Setter
    @Id
    @Column(name = "skill_name")
    private String skillName;
    @Getter
    @Setter
    @Column(name = "job_con_percentage")
    private String jobConfident;

}
