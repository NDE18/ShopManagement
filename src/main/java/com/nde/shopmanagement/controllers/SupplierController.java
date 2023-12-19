package com.nde.shopmanagement.controllers;

import com.nde.shopmanagement.controllers.api.SupplierApi;
import com.nde.shopmanagement.dto.SupplierDto;
import com.nde.shopmanagement.services.SupplierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(
        name = "Supplier Controller All CRUD API",
        description = "This class implements all the CRUD api related for supplier management"
)
public class SupplierController implements SupplierApi {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        return supplierService.save(supplierDto);
    }

    @Override
    public SupplierDto findById(Integer id) {
        return supplierService.findById(id);
    }

    @Override
    public SupplierDto findSupplierCode(String supplierCode) {
        return null;
    }

    @Override
    public List<SupplierDto> findAll() {
        return supplierService.findAll();
    }

    @Override
    public void delete(Integer id) {
        supplierService.delete(id);
    }
}
