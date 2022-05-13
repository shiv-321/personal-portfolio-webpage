package com.personal.portfolio.shivaraj.service;

import com.personal.portfolio.shivaraj.exception.ServiceNotFoundException;
import com.personal.portfolio.shivaraj.model.MyService;
import com.personal.portfolio.shivaraj.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MyServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    // to get list of all services
    public List<MyService> getAllServices() {
        List<MyService> allServices = new ArrayList<>();
        serviceRepository.findAll().forEach(allServices::add);
        return allServices;
    }

    public MyService createService(MyService myService) {

        return serviceRepository.save(myService);
    }

    public boolean updatedService(String serviceName, MyService myService) throws ServiceNotFoundException{
        var optionalService = serviceRepository.findById(serviceName);

        if (optionalService.isPresent()) {
            var service = optionalService.get();
            String serviceDescription = Objects.requireNonNullElse(myService.getServiceDescription(), service.getServiceDescription());
            service.setServiceDescription(serviceDescription);
            String icon = Objects.requireNonNullElse(myService.getIcon(), service.getIcon());
            service.setIcon(icon);

            serviceRepository.save(service);
            return true;

        } else {
            throw new ServiceNotFoundException(4004, "Th service you are trying to update is not available");
        }
    }
        public boolean deleteService(String serviceName) {
            serviceRepository.deleteById(serviceName);
            return true;
        }
    }
