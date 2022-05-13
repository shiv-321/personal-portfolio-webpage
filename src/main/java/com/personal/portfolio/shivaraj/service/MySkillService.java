package com.personal.portfolio.shivaraj.service;

import com.personal.portfolio.shivaraj.exception.ServiceNotFoundException;
import com.personal.portfolio.shivaraj.model.MyExperience;
import com.personal.portfolio.shivaraj.model.MySkill;
import com.personal.portfolio.shivaraj.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MySkillService {
    @Autowired
    SkillRepository skillRepository;

    // to get the list of skills

    public List<MySkill> getAllSkills (){
        List<MySkill> allSkills = new ArrayList<>();
        skillRepository.findAll().forEach(allSkills::add);
        return allSkills;
    }

    public MySkill createMySkills(MySkill mySkill){

        return skillRepository.save(mySkill);
    }

    public Boolean updateSkillService(String skillName, MySkill mySkill){
        var optionalMySkill = skillRepository.findById(skillName);

        if (optionalMySkill.isPresent()){
            var skill = optionalMySkill.get();
            String skillConfidence = Objects.requireNonNullElse(mySkill.getJobConfident(), skill.getJobConfident());
            skill.setJobConfident(skillConfidence);

            skillRepository.save(skill);
            return true;

        }else{
            throw new ServiceNotFoundException(404, "The skill confidence you are trying to update is not available");
        }
    }
    public boolean deleteSkillService(String skillName) {
        skillRepository.deleteById(skillName);
        return true;
    }
}
