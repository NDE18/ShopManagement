package com.nde.shopmanagement.controllers;

import com.nde.shopmanagement.controllers.api.SupplierOrderApi;
import com.nde.shopmanagement.dto.SupplierOrderDto;
import com.nde.shopmanagement.services.SupplierOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(
        name = "Supplier Order Controller All CRUD API",
        description = "This class implements all the CRUD api related for supplier order management"
)
public class SupplierOrderController implements SupplierOrderApi {

    private SupplierOrderService supplierOrderService;

    @Autowired
    public SupplierOrderController(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @Override
    public ResponseEntity<SupplierOrderDto> save(SupplierOrderDto supplierOrderDto) {
        return ResponseEntity.ok(supplierOrderService.save(supplierOrderDto));
    }

    @Override
    public ResponseEntity<SupplierOrderDto> findById(Integer id) {
        return ResponseEntity.ok(supplierOrderService.findById(id));
    }

    @Override
    public ResponseEntity<SupplierOrderDto> findSupplierOrderCode(String supplierOrderCode) {
        return ResponseEntity.ok(supplierOrderService.findByCode(supplierOrderCode));
    }

    @Override
    public ResponseEntity<List<SupplierOrderDto>> findAll() {
        return ResponseEntity.ok(supplierOrderService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        supplierOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
