package com.personal.portfolio.shivaraj.controller;

import com.personal.portfolio.shivaraj.model.*;
import com.personal.portfolio.shivaraj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class WebController {

    @Autowired
    MyPersonalInfoService myPersonalInfoService;
    @Autowired
    private MyServiceService myServiceService;
    @Autowired
    private MyEducationService myEducationService;
    @Autowired
    private MyExperienceService myExperienceService;
    @Autowired
    private MySkillService mySkillService;
    @Autowired
    private MyContactService myContactService;

    @GetMapping(value = "/")
        public String index (Model model){

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFullName("Shivaraj Thapa");
        personalInfo.setEmail("shivaraj.thapa2021@gmail.com");
        personalInfo.setAge(28);
        personalInfo.setAddress("Dallas, Texas");
        personalInfo.setCvUrl("https://drive.google.com/drive/my-drive");
        personalInfo.setCvDownloadIcon("fas fa-download");

        personalInfo.setDescription("I am experienced specialist with a demonstrated history of working in the forestry and environment sectors. I have sound experience in Arc GIS, Remote Sensing, Forestry Research, Data analysis using R programming, and its applications in environmental sampling and visualization with a strong academic background in forestry, natural resources, ecosystem, and forest economics and management. ");
        personalInfo.setTwitterLink("https://twitter.com/ShivarajThapa9");
        personalInfo.setLinkedinLink("https://www.linkedin.com/in/shivaraj-thapa-681443aa/");
        personalInfo.setResearchgateLink("https://www.researchgate.net/profile/Shivaraj-Thapa");
        personalInfo.setGithubLink("https://github.com/shiv-321");

        personalInfo.setYearsOfExperience(6);
        personalInfo.setHappyClient(10);
        personalInfo.setProjectsDone(15);
        personalInfo.setNumberOfAwards(3);

//        var personalInfo = myPersonalInfoService.getAllPersonalInfo();
        model.addAttribute("personalInfo", personalInfo);
        System.out.println(personalInfo);

//        Set<MyService> myServices = new HashSet<>();
//        myServices.add(new MyService("Forestry Research", "Conduct research on different sector of forestry such as forest management, forest fragmentation, forest economics and so on.","fas fa-palette"));
//        myServices.add(new MyService("GIS Mapping", "Collect spatial and non-spatial data using various technologies and represent the data by mapping. ", "fas fa-map"));
//        myServices.add(new MyService("Data Science Analyst", "Pull, manipulate, analyze, present findings to the company in an effort to make a data driven decision.", "fas fa-atom"));
//        myServices.add(new MyService("Data Analytics", "Built technical skills in a variety of programs and language.", "fas fa-database"));
//        myServices.add(new MyService("Data Analytics", "Built technical skills in a variety of programs and language.", "fas fa-palette"));
//        myServices.add(new MyService("Data Analytics", "Built technical skills in a variety of programs and language.", ""));
//        Collections.sort(myServices);

        var services = myServiceService.getAllServices();
        model.addAttribute("services", services);
        System.out.println(services);


//        List<MyEducation> myEducations = new ArrayList<>();
//        myEducations.add(new MyEducation("2017-2019", "Forest Economics and Management", "Beijing Forestry University", "Study emphasis: Forest Economics, Resource Economics, Econometrics, Forest Policy, Frontier, Forest Ecology, Modern Forestry.<br> Master’s Thesis: “Economic Valuation of Ecosystem services."));
//
//        myEducations.add(new MyEducation("2012-2016", "Forestry Science", "Institute of Forestry, Hetauda Campus", "Study emphasis: Forest management, Forest protection, Forest mensuration, GIS Applications in NRM, Digital Remote Sensing, Aerial Photo Interpretation and Photogrammetry, Experimental Design, Research Methodology, Forest Survey and Engineering, Hydrology, Soil Conservation, and Watershed Management. <br> Bachelor’s Thesis: “Opportunities and Challenges of Payment for Ecosystem Services."));
//
//        myEducations.add(new MyEducation("2009-2011", "Science", "Khowpa Higher Secondary School", "Study empahsis: Biology, Physics, Chemistry, English, Mathematics, Computer Science"));

        var myEducations = myEducationService.getAllEducation();
        model.addAttribute("myEducations", myEducations);
        System.out.println(myEducations);

//        List<MyExperience> myExperiences = new ArrayList<>();
//        myExperiences.add(new MyExperience("2019-2021", "Forestry and GIS Specialist", "ERM", "Conducted socio-economic, terrestrial environment survey, public consultation and public hearing for the Environmental Impact Assessment of the project."));
//        myExperiences.add(new MyExperience("2018-2019", "Data Analytics Specialist", "APFNet", "Conducted GPS/GIS data collection, surveying, mapping for report and analyzing the data for transmission line alignment."));
//        myExperiences.add(new MyExperience("2016-2017", "Forestry Specialist", "NFFRUN", "Executed the Forest Resources Inventory and Mapping of project area(Watershed delineation, Land cover, Vegetation, Soil, and Slope maps) using , Forest Resources Assessment (FRA), National Land Use Database, topographic map and USDA soil map"));

        var myExperiences = myExperienceService.getAllExperience();
        model.addAttribute("myExperiences", myExperiences);

//        List<MySkill> mySkills = new ArrayList<>();
//        mySkills.add(new MySkill("Quantitative/ qualitative research skills", "70%"));
//        mySkills.add(new MySkill("Geographic information system (GIS)", "80%"));
//        mySkills.add(new MySkill("SQL", "60%"));
//        mySkills.add(new MySkill("Python and R programming", "65%"));

        var mySkills = mySkillService.getAllSkills();
        model.addAttribute("mySkills", mySkills);

        List<MyTestimonial> myTestimonials = new ArrayList<>();

        model.addAttribute("myTestimonials", myTestimonials);

//        MyContact contactMe = new MyContact();

//        contactMe.setFullAddress("713 Redding dr, Saginaw, Texas, 76131");
//        contactMe.setEmailAddress("shivaraj.thapa@gmail.com");
//        contactMe.setPhoneNumber("6823464682");
//        contactMe.setFollowMe("Follow Me");

        var contactMe = myContactService.getAllContactInfo();
        model.addAttribute("contactMe", contactMe);

        return "index";
        }
    }

