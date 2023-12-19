package com.nde.shopmanagement.controllers;

import com.nde.shopmanagement.controllers.api.CustomerOrderApi;
import com.nde.shopmanagement.dto.CustomerOrderDto;
import com.nde.shopmanagement.services.CustomerOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(
        name = "Customer order Controller All CRUD API",
        description = "This class implements all the CRUD api related for customer order management"
)
public class CustomerOrderController implements CustomerOrderApi {

    private CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @Override
    public ResponseEntity<CustomerOrderDto> save(CustomerOrderDto customerOrderDto) {
        return ResponseEntity.ok(customerOrderService.save(customerOrderDto));
    }

    @Override
    public ResponseEntity<CustomerOrderDto> findById(Integer id) {
        return ResponseEntity.ok(customerOrderService.findById(id));
    }

    @Override
    public ResponseEntity<CustomerOrderDto> findCustomerOrderCode(String customerOrderCode) {
        return ResponseEntity.ok(customerOrderService.findByCode(customerOrderCode));
    }

    @Override
    public ResponseEntity<List<CustomerOrderDto>> findAll() {
        return ResponseEntity.ok(customerOrderService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        customerOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
