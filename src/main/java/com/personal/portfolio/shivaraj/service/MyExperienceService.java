package com.personal.portfolio.shivaraj.service;

import com.personal.portfolio.shivaraj.exception.ServiceNotFoundException;
import com.personal.portfolio.shivaraj.model.MyEducation;
import com.personal.portfolio.shivaraj.model.MyExperience;
import com.personal.portfolio.shivaraj.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyExperienceService {
    @Autowired
    ExperienceRepository experienceRepository;

    // to get the list of experience
    public List<MyExperience> getAllExperience(){
        List<MyExperience> allExperience = new ArrayList<>();
        experienceRepository.findAll().forEach(allExperience::add);
        return allExperience;
    }
    public MyExperience createMyExperienceDetail(MyExperience myExperience){
        return experienceRepository.save(myExperience);
    }

    public Boolean updateExperienceService(String position, MyExperience myExperience){
        var optionalMyExperience = experienceRepository.findById(position);

        if (optionalMyExperience.isPresent()){
            var experience = optionalMyExperience.get();
            String jobYear = Objects.requireNonNullElse(myExperience.getJobYear(), experience.getJobYear());
            experience.setJobYear(jobYear);
            String workedOrganization = Objects.requireNonNullElse(myExperience.getOrganization(), experience.getOrganization());
            experience.setOrganization(workedOrganization);
            String jobDescription = Objects.requireNonNullElse(myExperience.getJobDescription(), myExperience.getJobDescription());
            experience.setJobDescription(jobDescription);

            experienceRepository.save(experience);
            return true;

        }else{
            throw new ServiceNotFoundException(404, "The experience detail you are trying to update is not available");
        }
    }
    public boolean deleteExperienceService(String position) {
        experienceRepository.deleteById(position);
        return true;
    }
}
