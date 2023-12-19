package com.nde.shopmanagement.controllers;

import com.nde.shopmanagement.controllers.api.BusinessApi;
import com.nde.shopmanagement.dto.BusinessDto;
import com.nde.shopmanagement.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessController implements BusinessApi {

    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Override
    public ResponseEntity<BusinessDto> save(BusinessDto businessDto) {
        return ResponseEntity.ok(businessService.save(businessDto));
    }

    @Override
    public ResponseEntity<BusinessDto> findById(Integer id) {
        return ResponseEntity.ok(businessService.findById(id));
    }

    @Override
    public ResponseEntity<BusinessDto> findBusinessCode(String businessCode) {
        return ResponseEntity.ok(businessService.findCode(businessCode));
    }

    @Override
    public ResponseEntity<List<BusinessDto>> findAll() {
        return ResponseEntity.ok(businessService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        businessService.delete(id);
        return ResponseEntity.ok().build();
    }
}
