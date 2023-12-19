package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.BusinessDto;
import com.nde.shopmanagement.entities.Business;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.BusinessRepository;
import com.nde.shopmanagement.services.BusinessService;
import com.nde.shopmanagement.validators.BusinessValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService {

    private BusinessRepository businessRepository;

    @Autowired
    public BusinessServiceImpl(BusinessRepository businessRepository){
        this.businessRepository = businessRepository;
    }
    @Override
    public BusinessDto save(BusinessDto businessDto) {
        List<String> errors = BusinessValidator.validate(businessDto);
        if (!errors.isEmpty()){
            log.error("Business is invalid {}", businessDto);
            throw new InvalidEntityException("Business is not valid", ErrorCodes.BUSINESS_NOT_FOUND, errors);
        }
        return BusinessDto.fromEntity(businessRepository.save(BusinessDto.toEntity(businessDto)));
    }

    @Override
    public BusinessDto findById(Integer id) {
        if (id == null){
            log.error("ID Business is null {}", id);
            return null;
        }
        Optional<Business> business = businessRepository.findById(id);
        BusinessDto businessDto = BusinessDto.fromEntity(business.get());
        return Optional.of(businessDto).orElseThrow(() -> new EntityNotFoundException(
                "No Business with ID = "+id+" found.",
                ErrorCodes.BUSINESS_NOT_FOUND));
    }

    @Override
    public BusinessDto findCode(String itemCode) {
        return null;
    }

    @Override
    public List<BusinessDto> findAll() {
        return businessRepository.findAll().stream()
                .map(BusinessDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        businessRepository.deleteById(id);
    }
}
