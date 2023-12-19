package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.CustomerOrderDto;
import com.nde.shopmanagement.dto.CustomerOrderLineDto;
import com.nde.shopmanagement.entities.Customer;
import com.nde.shopmanagement.entities.CustomerOrder;
import com.nde.shopmanagement.entities.CustomerOrderLine;
import com.nde.shopmanagement.entities.Item;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.CustomerOrderLineRepository;
import com.nde.shopmanagement.repositories.CustomerOrderRepository;
import com.nde.shopmanagement.repositories.CustomerRepository;
import com.nde.shopmanagement.repositories.ItemRepository;
import com.nde.shopmanagement.services.CustomerOrderService;
import com.nde.shopmanagement.validators.CustomerOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private CustomerOrderRepository customerOrderRepository;
    private CustomerRepository customerRepository;
    private CustomerOrderLineRepository customerOrderLineRepository;
    private ItemRepository itemRepository;

    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository,
                                    CustomerRepository customerRepository,
                                    ItemRepository itemRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public CustomerOrderDto save(CustomerOrderDto customerOrderDto) {
        List<String> errors = CustomerOrderValidator.validate(customerOrderDto);
        if (!errors.isEmpty()){
            log.error("Customer order is not valid");
            throw new InvalidEntityException("Customer order is not valid", ErrorCodes.CUSTOMER_ORDER_NOT_VALID);
        }

        Optional<Customer> customer = customerRepository.findById(customerOrderDto.getCustomer().getId());
        if (!customer.isPresent()){
            log.warn("Customer with ID {} not found", customerOrderDto.getCustomer().getId());
            throw new EntityNotFoundException("No customer with ID {} has been found",ErrorCodes.CUSTOMER_NOT_FOUND);
        }

        List<String> itemErrors = new ArrayList<>();

        if (customerOrderDto.getCustomerOrderLines() != null){
            customerOrderDto.getCustomerOrderLines().forEach(linOrCus -> {
                if (linOrCus.getItem() != null){
                    Optional<Item> item = itemRepository.findById(linOrCus.getItem().getId());
                    if (item.isEmpty()){
                        itemErrors.add("Item with ID {}" + linOrCus.getItem().getId() + " not found");
                    }
                } else {
                    itemErrors.add("Impossible to save an order with null item");
                }
            });
        }

        if (!itemErrors.isEmpty()){
            log.warn("Item ID provided is not valid");
            throw new InvalidEntityException("Item do not exist", ErrorCodes.ITEM_NOT_FOUND, itemErrors);
        }

        CustomerOrder savedCustOrder = customerOrderRepository.save(CustomerOrderDto.toEntity(customerOrderDto));

        if (customerOrderDto.getCustomerOrderLines() != null){
            customerOrderDto.getCustomerOrderLines().forEach(linCustOrder -> {
                CustomerOrderLine customerOrderLine = CustomerOrderLineDto.toEntity(linCustOrder);
                customerOrderLine.setCustomerOrder(savedCustOrder);
                customerOrderLineRepository.save(customerOrderLine);
            });
        }

        return CustomerOrderDto.fromEntity(savedCustOrder);
    }

    @Override
    public CustomerOrderDto findById(Integer id) {
        if (id == null){
            log.error("Customer order ID is null");
            return null;
        }

        return customerOrderRepository.findById(id)
                .map(CustomerOrderDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No customer order found with ID "+ id, ErrorCodes.CUSTOMER_ORDER_NOT_FOUND
                ));
    }

    @Override
    public CustomerOrderDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Customer order code is NULL");
            return null;
        }
        return customerOrderRepository.findByCode(code)
                .map(CustomerOrderDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No customer order found with CODE "+ code, ErrorCodes.CUSTOMER_ORDER_NOT_FOUND
                ));
    }

    @Override
    public List<CustomerOrderDto> findAll() {
        return customerOrderRepository.findAll()
                .stream().map(CustomerOrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        customerOrderRepository.deleteById(id);
    }
}
