package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.CustomerDto;
import com.nde.shopmanagement.entities.Customer;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.CustomerRepository;
import com.nde.shopmanagement.services.CustomerService;
import com.nde.shopmanagement.validators.CustomerValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerDto save(CustomerDto customerDto) {
        List<String> errors = CustomerValidator.validate(customerDto);
        if (!errors.isEmpty()){
            log.error("Customer is not valid {}", customerDto);
            throw new InvalidEntityException("Category is not valid", ErrorCodes.CUSTOMER_NOT_FOUND, errors);
        }
        return CustomerDto.fromEntity(customerRepository.save(CustomerDto.toEntity(customerDto)));
    }

    @Override
    public CustomerDto findById(Integer id) {
        if (id == null){
            log.error("ID Customer is null {}", id);
            return null;
        }
        Optional<Customer> customer = customerRepository.findById(id);
        CustomerDto customerDto = CustomerDto.fromEntity(customer.get());
        return Optional.of(customerDto).orElseThrow(() -> new EntityNotFoundException(
                "No Customer with ID = "+id+" found.",
                ErrorCodes.CUSTOMER_NOT_FOUND));
    }

    @Override
    public CustomerDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("CODE Customer is null {}", code);
            return null;
        }
        Optional<Customer> customer = customerRepository.findByCode(code);

        CustomerDto customerDto = CustomerDto.fromEntity(customer.get());
        return Optional.of(customerDto).orElseThrow(() -> new EntityNotFoundException(
                "No customer with ID = "+code+" found.",
                ErrorCodes.CUSTOMER_NOT_FOUND
        ));
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        customerRepository.deleteById(id);
    }
}
