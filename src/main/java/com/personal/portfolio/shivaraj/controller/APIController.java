package com.personal.portfolio.shivaraj.controller;

import com.personal.portfolio.shivaraj.model.*;
import com.personal.portfolio.shivaraj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.logging.Logger;

@RestController
public class APIController {
    @Autowired
    MyPersonalInfoService myPersonalInfoService;
    @Autowired
    MyServiceService myServiceService;
    @Autowired
    MyEducationService myEducationService;
    @Autowired
    MyExperienceService myExperienceService;
    @Autowired
    MySkillService mySkillService;
    @Autowired
    MyContactService myContactService;

    @GetMapping(value = "/api/get-personal-info")
    public HashMap<String, Object> getPersonalInfo() {

//        PersonalInfo personalInfo = new PersonalInfo();
//
//        personalInfo.setFullName("Shivaraj Thapa");
//        personalInfo.setEmail("shivaraj.thapa2021@gmail.com");
//        personalInfo.setAge(28);
//        personalInfo.setAddress("Dallas, Texas");
//        personalInfo.setCvUrl("https://drive.google.com/drive/my-drive");
//        personalInfo.setCvDownloadIcon("fas fa-download");
//
//        personalInfo.setDescription("I am experienced specialist with a demonstrated history of working in the forestry and environment sectors. I have sound experience in Arc GIS, Remote Sensing, Forestry Research, Data analysis using R programming, and its applications in environmental sampling and visualization with a strong academic background in forestry, natural resources, ecosystem, and forest economics and management. ");
//        personalInfo.setTwitterLink("https://twitter.com/ShivarajThapa9");
//        personalInfo.setLinkedinLink("https://www.linkedin.com/in/shivaraj-thapa-681443aa/");
//        personalInfo.setResearchgateLink("https://www.researchgate.net/profile/Shivaraj-Thapa");
//        personalInfo.setGithubLink("https://github.com/shiv-321");
//
//        personalInfo.setYearsOfExperience(6);
//        personalInfo.setHappyClient(10);
//        personalInfo.setProjectsDone(15);
//        personalInfo.setNumberOfAwards(3);

        var personalInfo = myPersonalInfoService.getAllPersonalInfo();

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("status", "success");
        map1.put("data", personalInfo);
        return map1;
    }
    @PostMapping(value = "/api/get-personal-info")
    public HashMap<String, Object> addPersonalInfo(@RequestBody PersonalInfo personalInfo) {

        var createdMyPersonalInfo = myPersonalInfoService.createPersonalInfo(personalInfo);
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("status", "success");
        map1.put("data", createdMyPersonalInfo);
        return map1;
    }

    @PutMapping(value = "/api/get-personal-info/{email}")
    public HashMap<String, Object> updatePersonalInfo(@PathVariable(name = "email") String email, @RequestBody PersonalInfo personalInfo) {

        boolean isUpdated = myPersonalInfoService.updatePersonalInfo(email, personalInfo);

        HashMap<String, Object> map1 = new HashMap<>();

        if (isUpdated) {
            map1.put("status", "success");
            map1.put("data", personalInfo);
            map1.put("message", "The personal information detail is successfully created");
        } else {
            map1.put("status", "failure");
            map1.put("message", "Unable to update the personal information. ");
        }

        return map1;
    }

    @DeleteMapping(value = "/api/get-personal-info/{email}")
    public HashMap<String, Object> deletePersonalInformation(@PathVariable(name = "email") String email) {

        var isDeleted = myPersonalInfoService.deletePersonalInformation(email);

        HashMap<String, Object> map1 = new HashMap<>();

        if (isDeleted) {
            map1.put("status", "success");
            map1.put("message", "The personal detail is successfully deleted");
        } else {
            map1.put("status", "failure");
            map1.put("message", "Unable to delete the required personal information.");
        }

        return map1;
    }


    @GetMapping(value = "/api/get-my-service")
    public HashMap<String, Object> getMyService() {

//        Set<MyService> myServices = new HashSet<>();
//        myServices.add(new MyService("Forestry Research", "Conduct research on different sector of forestry such as forest management, forest fragmentation, forest economics and so on.","fas fa-palette"));
//        myServices.add(new MyService("GIS Mapping", "Collect spatial and non-spatial data using various technologies and represent the data by mapping .", "fas fa-palette"));
//        myServices.add(new MyService("Data Science Analyst", "Pull, manipulate, analyze, present findings to the company in an effort to make a data driven decision.", "fas fa-palette"));
//        myServices.add(new MyService("Data Analytics", "Built technical skills in a variety of programs and language.", "fas fa-palette"));
//        myServices.add(new MyService("Data Analytics", "Built technical skills in a variety of programs and language.", "fas fa-palette"));

        var myServiceList = myServiceService.getAllServices();

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("status", "success");
        map2.put("data", myServiceList);
        return map2;
    }

    // to create or add the data from user
    @PostMapping(value = "/api/get-my-service")
    public HashMap<String, Object> addService(@Valid @RequestBody MyService myService) {
        Logger.getGlobal().info(myService.toString());

        var createdService = myServiceService.createService(myService);

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("status", "success");
        map2.put("data", createdService);
        map2.put("message", "The service is successfully created");
        return map2;
    }

    @PutMapping(value = "/api/get-my-service/{serviceName}")
    public HashMap<String, Object> updateService(@PathVariable(name = "serviceName") String serviceName, @RequestBody MyService myService) {
        Logger.getGlobal().info(myService.toString());
        Logger.getGlobal().info(serviceName);

        boolean isUpdated = myServiceService.updatedService(serviceName, myService);

        HashMap<String, Object> map2 = new HashMap<>();

        if (isUpdated) {
            map2.put("status", "success");
            map2.put("data", myService);
            map2.put("message", "The service is successfully created");
        } else {
            map2.put("status", "failure");
            map2.put("message", "Unable to update the service. Please check your service name.");
        }

        return map2;
    }

    @DeleteMapping(value = "/api/get-my-service/{serviceName}")
    public HashMap<String, Object> deleteService(@PathVariable(name = "serviceName") String serviceName) {

        var isDeleted = myServiceService.deleteService(serviceName);

        HashMap<String, Object> map2 = new HashMap<>();

        if (isDeleted) {
            map2.put("status", "success");
            map2.put("message", "The service is successfully deleted");
        } else {
            map2.put("status", "failure");
            map2.put("message", "Unable to delete the service. Please check your service name.");
        }

        return map2;
    }

    @GetMapping(value = "/api/get-my-education-details")
    public HashMap<String, Object> getMyEducationDetails(){
//
//        List<MyEducation> myEducations = new ArrayList<>();
//        myEducations.add(new MyEducation("2017-2019", "Forest Economics and Management", "Beijing Forestry University", "Study emphasis: Forest Economics, Resource Economics, Econometrics, Forest Policy, Frontier, Forest Ecology, Modern Forestry.\n" +
//                "Master’s Thesis: “Economic Valuation of Ecosystem services.\n"));
//
//        myEducations.add(new MyEducation("2012-2016", "Forestry Science", "Institute of Forestry, Hetauda Campus", "Study emphasis: Forest management, Forest protection, Forest mensuration, GIS Applications in NRM, Digital Remote Sensing, Aerial Photo Interpretation and Photogrammetry, Experimental Design, Research Methodology, Forest Survey and Engineering, Hydrology, Soil Conservation, and Watershed Management.\n" +
//                "Bachelor’s Thesis: “Opportunities and Challenges of Payment for Ecosystem Services.\n"));
//
//        myEducations.add(new MyEducation("2009-2011", "Science", "Khowpa Higher Secondary School", "Study empahsis: Biology, Physics, Chemistry, English, Mathematics, Computer Science"));

        var myEducations = myEducationService.getAllEducation();

        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("status", "success");
        map3.put("data", myEducations );
        return map3;
    }

    @PostMapping(value = "/api/get-my-education-details")
    public HashMap<String, Object> addMyEducationDetails(@RequestBody MyEducation myEducation){

        var createdEducationDetail = myEducationService.createEducationDetail(myEducation);
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("status", "success");
        map3.put("data", createdEducationDetail);
        return map3;
    }

    @PutMapping(value = "/api/get-my-education-details/{degreeName}")
    public HashMap<String, Object> updateEducationService(@PathVariable(name = "degreeName") String degreeName, @RequestBody MyEducation myEducation){


        boolean isUpdated = myEducationService.updateEducationService(degreeName, myEducation);

        HashMap<String, Object> map3 = new HashMap<>();

        if (isUpdated) {
            map3.put("status", "success");
            map3.put("data", myEducation);

        } else {
            map3.put("status", "failure");
            map3.put("message", "Unable to update the education detail. Please check your degree name.");
        }

        return map3;
    }

    @DeleteMapping(value = "/api/get-my-education-details/{degreeName}")
    public HashMap<String, Object> deleteEducationService(@PathVariable(name = "degreeName") String degreeName) {

        var isDeleted = myEducationService.deleteEducationService(degreeName);

        HashMap<String, Object> map3 = new HashMap<>();

        if (isDeleted) {
            map3.put("status", "success");
            map3.put("message", "The Education service is successfully deleted");
        } else {
            map3.put("status", "failure");
            map3.put("message", "Unable to delete the Education service.");
        }
        return map3;
    }

    @GetMapping(value = "/api/get-my-experience-detail")
    public HashMap<String, Object> getMyExperienceDetail(){

//        List<MyExperience> myExperiences = new ArrayList<>();
//        myExperiences.add(new MyExperience("2019-2021", "Forestry and GIS Specialist", "ERM", "Conducted socio-economic, terrestrial environment survey, public consultation and public hearing for the Environmental Impact Assessment of the project."));
//        myExperiences.add(new MyExperience("2018-2019", "Data Analytics Specialist", "APFNet", "Conducted GPS/GIS data collection, surveying, mapping for report and analyzing the data for transmission line alignment."));
//        myExperiences.add(new MyExperience("2016-2017", "Forestry Specialist", "NFFRUN", "Executed the Forest Resources Inventory and Mapping of project area(Watershed delineation, Land cover, Vegetation, Soil, and Slope maps) using , Forest Resources Assessment (FRA), National Land Use Database, topographic map and USDA soil map"));

        var myExperiences = myExperienceService.getAllExperience();
        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("status", "success");
        map4.put("data", myExperiences );

        return map4;
    }
    @PostMapping(value = "/api/get-my-experience-detail")
    public HashMap<String, Object> addMyExperienceDetail(@RequestBody MyExperience myExperience){

        var createdExperienceDetail = myExperienceService.createMyExperienceDetail(myExperience);

        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("status", "success");
        map4.put("data", createdExperienceDetail );

        return map4;
    }

    @PutMapping(value = "/api/get-my-experience-detail/{position}")
    public HashMap<String, Object> updateExperienceService(@PathVariable(name = "position") String position, @RequestBody MyExperience myExperience){

        boolean isUpdated = myExperienceService.updateExperienceService(position, myExperience);

        HashMap<String, Object> map4 = new HashMap<>();

        if (isUpdated) {
            map4.put("status", "success");
            map4.put("data", myExperience);

        } else {
            map4.put("status", "failure");
            map4.put("message", "Unable to update the experience detail.");
        }

        return map4;
    }

    @DeleteMapping(value = "/api/get-my-experience-detail/{position}")
    public HashMap<String, Object> deleteExperienceService(@PathVariable(name = "position") String position) {

        var isDeleted = myExperienceService.deleteExperienceService(position);

        HashMap<String, Object> map4 = new HashMap<>();

        if (isDeleted) {
            map4.put("status", "success");
            map4.put("message", "The experience service is successfully deleted");
        } else {
            map4.put("status", "failure");
            map4.put("message", "Unable to delete the experience service.");
        }
        return map4;
    }

        @GetMapping(value = "/api/get-my-skills")
    public HashMap<String, Object> getMySkills(){

//        List<MySkill> mySkills = new ArrayList<>();
//        mySkills.add(new MySkill("Quantitative/ qualitative research skills", "70%"));
//        mySkills.add(new MySkill("Geographic information system (GIS)", "80%"));
//        mySkills.add(new MySkill("SQL", "60%"));
//        mySkills.add(new MySkill("Python and R programming", "65%"));

        var mySkills = mySkillService.getAllSkills();

        HashMap<String, Object> map5 = new HashMap<>();
        map5.put("status", "success");
        map5.put("data", mySkills );

        return map5;
    }

    @PostMapping(value = "/api/get-my-skills")
    public HashMap<String, Object> addMySkills(@RequestBody MySkill mySkill) {

        var createdMySkills = mySkillService.createMySkills(mySkill);
        HashMap<String, Object> map5 = new HashMap<>();
        map5.put("status", "success");
        map5.put("data", createdMySkills);

        return map5;
    }

    @PutMapping(value = "/api/get-my-skills/{skillName}")
    public HashMap<String, Object> updateSkillService(@PathVariable(name = "skillName") String skillName, @RequestBody MySkill mySkill){

        boolean isUpdated = mySkillService.updateSkillService(skillName, mySkill);

        HashMap<String, Object> map5 = new HashMap<>();

        if (isUpdated) {
            map5.put("status", "success");
            map5.put("data", mySkill);

        } else {
            map5.put("status", "failure");
            map5.put("message", "Unable to update the skill confidence detail.");
        }

        return map5;
    }

    @DeleteMapping(value = "/api/get-my-skills/{skillName}")
    public HashMap<String, Object> deleteSkillService(@PathVariable(name = "skillName") String skillName) {

        var isDeleted = mySkillService.deleteSkillService(skillName);

        HashMap<String, Object> map5 = new HashMap<>();

        if (isDeleted) {
            map5.put("status", "success");
            map5.put("message", "The skill service is successfully deleted");
        } else {
            map5.put("status", "failure");
            map5.put("message", "Unable to delete the skill service.");
        }
        return map5;
    }

    @GetMapping(value = "/api/my-contact")
    public HashMap<String, Object>getMyContact() {

//        ContactMe contactMe = new ContactMe();
//
//        contactMe.setFullAddress("713 Redding dr, Saginaw, Texas, 76131");
//        contactMe.setEmailAddress("shivaraj.thapa@gmail.com");
//        contactMe.setPhoneNumber("6823464682");
//        contactMe.setFollowMe("Follow Me");

        var contactMe = myContactService.getAllContactInfo();

        HashMap<String, Object> map6 = new HashMap<>();
        map6.put("status", "success");
        map6.put("data", contactMe );

        return map6;
    }

    @PostMapping(value = "/api/my-contact")
    public HashMap<String, Object> addMyContact(@RequestBody MyContact myContact) {

        var createdContactInformation = myContactService.createAllContactInfo(myContact);
        HashMap<String, Object> map6 = new HashMap<>();
        map6.put("status", "success");
        map6.put("data", createdContactInformation );

        return map6;
    }
    @PutMapping(value = "/api/my-contact/{emailAddress}")
    public HashMap<String, Object> updateContactInformation(@PathVariable(name = "emailAddress") String emailAddress, @RequestBody MyContact myContact){

        boolean isUpdated = myContactService.updateContactService(emailAddress, myContact);

        HashMap<String, Object> map5 = new HashMap<>();

        if (isUpdated) {
            map5.put("status", "success");
            map5.put("data", myContact);

        } else {
            map5.put("status", "failure");
            map5.put("message", "Unable to update the my contact information.");
        }

        return map5;
    }

    @DeleteMapping(value = "/api/my-contact/{emailAddress}")
    public HashMap<String, Object> deleteContactInformation(@PathVariable(name = "emailAddress") String emailAddress) {

        var isDeleted = myContactService.deleteContactInformation(emailAddress);

        HashMap<String, Object> map5 = new HashMap<>();

        if (isDeleted) {
            map5.put("status", "success");
            map5.put("message", "The my contact information is successfully deleted");
        } else {
            map5.put("status", "failure");
            map5.put("message", "Unable to delete the my contact information detail.");
        }
        return map5;
    }
}
