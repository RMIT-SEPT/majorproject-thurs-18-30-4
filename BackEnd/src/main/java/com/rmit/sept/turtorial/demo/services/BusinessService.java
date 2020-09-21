package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.exception.BusinessException;
import com.rmit.sept.turtorial.demo.model.Business;
import com.rmit.sept.turtorial.demo.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusinessService {
    @Autowired
    BusinessRepository businessRepository;

    // saves a business into the business repository
    // throws an exception if the business has an id
    public Business createBusiness(Business business) {
        if (business.getId() != null) {
            throw new BusinessException(String.format("New business must not have an id"));
        }

        return businessRepository.save(business);
    }

    // returns a business object from business repository based on given id
    public Business findBusinessById(Long id) {
        Optional<Business> business = businessRepository.findById(id);

        if (!business.isPresent()) {
            throw new BusinessException(String.format("Business was not found for id = %s", id));
        }

        return business.get();
    }


}
