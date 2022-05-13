package com.personal.portfolio.shivaraj.service;

import com.personal.portfolio.shivaraj.exception.ServiceNotFoundException;
import com.personal.portfolio.shivaraj.model.MyExperience;
import com.personal.portfolio.shivaraj.model.PersonalInfo;
import com.personal.portfolio.shivaraj.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyPersonalInfoService {
    @Autowired
    PersonalInfoRepository personalInfoRepository;

    public List<PersonalInfo> getAllPersonalInfo(){
        List<PersonalInfo> allPersonalInfo = new ArrayList<>();
        personalInfoRepository.findAll().forEach(allPersonalInfo::add);
        return allPersonalInfo;
    }
    public PersonalInfo createPersonalInfo(PersonalInfo personalInfo){
        return personalInfoRepository.save(personalInfo);
    }

    public Boolean updatePersonalInfo(String email, PersonalInfo personalInfo){
        var optionalPersonalInfo = personalInfoRepository.findById(email);

        if (optionalPersonalInfo.isPresent()){
            var myDetail = optionalPersonalInfo.get();
            String name = Objects.requireNonNullElse(personalInfo.getFullName(), myDetail.getFullName());
            myDetail.setFullName(name);

            int age = Objects.requireNonNullElse(personalInfo.getAge(), myDetail.getAge());
            myDetail.setAge(age);

            String address = Objects.requireNonNullElse(personalInfo.getAddress(), myDetail.getAddress());
            myDetail.setAddress(address);

            String cvUrl = Objects.requireNonNullElse(personalInfo.getCvUrl(), myDetail.getCvUrl());
            myDetail.setCvUrl(cvUrl);

            String cvDownloadIcon = Objects.requireNonNullElse(personalInfo.getCvDownloadIcon(), myDetail.getCvDownloadIcon());
            myDetail.setCvDownloadIcon(cvDownloadIcon);

            String description = Objects.requireNonNullElse(personalInfo.getDescription(), myDetail.getDescription());
            myDetail.setDescription(description);

            String twitterLink = Objects.requireNonNullElse(personalInfo.getTwitterLink(), myDetail.getTwitterLink());
            myDetail.setTwitterLink(twitterLink);

            String linkedinLink = Objects.requireNonNullElse(personalInfo.getLinkedinLink(), myDetail.getLinkedinLink());
            myDetail.setLinkedinLink(linkedinLink);

            String researchgateLink = Objects.requireNonNullElse(personalInfo.getResearchgateLink(), myDetail.getResearchgateLink());
            myDetail.setResearchgateLink(researchgateLink);

            String githubLink = Objects.requireNonNullElse(personalInfo.getGithubLink(), myDetail.getGithubLink());
            myDetail.setGithubLink(githubLink);

            int yearsOfExperience = Objects.requireNonNullElse(personalInfo.getYearsOfExperience(), myDetail.getYearsOfExperience());
            myDetail.setYearsOfExperience(yearsOfExperience);

            int happyClient = Objects.requireNonNullElse(personalInfo.getHappyClient(), myDetail.getHappyClient());
            myDetail.setHappyClient(happyClient);

            int projectsDone = Objects.requireNonNullElse(personalInfo.getProjectsDone(), myDetail.getProjectsDone());
            myDetail.setProjectsDone(projectsDone);

            int numberOfAwards = Objects.requireNonNullElse(personalInfo.getNumberOfAwards(), myDetail.getNumberOfAwards());
            myDetail.setNumberOfAwards(numberOfAwards);

            personalInfoRepository.save(myDetail);
            return true;

        }else{
            throw new ServiceNotFoundException(404, "The personal information you are trying to update is not available");
        }
    }
    public boolean deletePersonalInformation(String email) {
        personalInfoRepository.deleteById(email);
        return true;
    }
}

