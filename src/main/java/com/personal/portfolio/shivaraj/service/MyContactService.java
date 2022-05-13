package com.personal.portfolio.shivaraj.service;

import com.personal.portfolio.shivaraj.exception.ServiceNotFoundException;
import com.personal.portfolio.shivaraj.model.MyContact;
import com.personal.portfolio.shivaraj.model.MyExperience;
import com.personal.portfolio.shivaraj.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyContactService {
    @Autowired
    ContactRepository contactRepository;

    public List<MyContact> getAllContactInfo(){
        List<MyContact> allContactInfo = new ArrayList<>();
        contactRepository.findAll().forEach(allContactInfo::add);
        return allContactInfo;
    }

    public MyContact createAllContactInfo (MyContact myContact){

        return contactRepository.save(myContact);
    }
    public Boolean updateContactService(String emailAddress, MyContact myContact){
        var optionalMyContact = contactRepository.findById(emailAddress);

        if (optionalMyContact.isPresent()){
            var contactMe = optionalMyContact.get();
            String fullAddress = Objects.requireNonNullElse(myContact.getFullAddress(), contactMe.getFullAddress());
            contactMe.setFullAddress(fullAddress);

            String phoneNumber = Objects.requireNonNullElse(myContact.getPhoneNumber(), contactMe.getPhoneNumber());
            contactMe.setPhoneNumber(phoneNumber);

            String followMe = Objects.requireNonNullElse(myContact.getFollowMe(), contactMe.getFollowMe());
            contactMe.setFollowMe(followMe);

            contactRepository.save(contactMe);
            return true;

        }else{
            throw new ServiceNotFoundException(404, "The contact detail you are trying to update is not available");
        }
    }
    public boolean deleteContactInformation(String emailAddress) {
        contactRepository.deleteById(emailAddress);
        return true;
    }
}

