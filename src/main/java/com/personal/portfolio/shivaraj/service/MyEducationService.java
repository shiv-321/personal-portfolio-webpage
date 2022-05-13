package com.personal.portfolio.shivaraj.service;

import com.personal.portfolio.shivaraj.exception.ServiceNotFoundException;
import com.personal.portfolio.shivaraj.model.MyEducation;
import com.personal.portfolio.shivaraj.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyEducationService {
    @Autowired
    EducationRepository educationRepository;

    // to get the list of education
    public List<MyEducation> getAllEducation(){
        List<MyEducation> allEducation = new ArrayList<>();
        educationRepository.findAll().forEach(allEducation::add);
        return allEducation;
    }

    public MyEducation createEducationDetail(MyEducation myEducation){

        return educationRepository.save(myEducation);
    }

    public Boolean updateEducationService(String degreeName, MyEducation myEducation){
        var optionalMyEducation = educationRepository.findById(degreeName);

        if (optionalMyEducation.isPresent()){
            var education = optionalMyEducation.get();
            String educationYear = Objects.requireNonNullElse(myEducation.getYear(), education.getYear());
            education.setYear(educationYear);
            String studiedUniversity = Objects.requireNonNullElse(myEducation.getUniversity(), education.getUniversity());
            education.setUniversity(studiedUniversity);
            String educationDescription = Objects.requireNonNullElse(myEducation.getEducationDescription(), education.getEducationDescription());
            education.setEducationDescription(educationDescription);

            educationRepository.save(education);
            return true;

        }else{
            throw new ServiceNotFoundException(404, "The education you are trying to update is not available");
        }
    }
    public boolean deleteEducationService(String degreeName) {
        educationRepository.deleteById(degreeName);
        return true;
    }
}
