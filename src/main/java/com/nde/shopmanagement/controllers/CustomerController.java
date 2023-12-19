package com.nde.shopmanagement.controllers;

import com.nde.shopmanagement.controllers.api.CustomerApi;
import com.nde.shopmanagement.dto.CustomerDto;
import com.nde.shopmanagement.services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(
        name = "Customer Controller All CRUD API",
        description = "This class implements all the CRUD api related for customer management"
)
public class CustomerController implements CustomerApi {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerService.save(customerDto);
    }

    @Override
    public CustomerDto findById(Integer id) {
        return customerService.findById(id);
    }

    @Override
    public CustomerDto findCustomerCode(String customerCode) {
        return customerService.findByCode(customerCode);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

    @Override
    public void delete(Integer id) {
        customerService.delete(id);
    }
}
