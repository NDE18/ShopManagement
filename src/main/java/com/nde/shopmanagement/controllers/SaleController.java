package com.nde.shopmanagement.controllers;

import com.nde.shopmanagement.controllers.api.SaleApi;
import com.nde.shopmanagement.dto.SaleDto;
import com.nde.shopmanagement.services.SaleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(
        name = "Sale Controller All CRUD API",
        description = "This class implements all the CRUD api related for sale management"
)
public class SaleController implements SaleApi {

    private SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @Override
    public ResponseEntity<SaleDto> save(SaleDto saleDto) {
        return ResponseEntity.ok(saleService.save(saleDto));
    }

    @Override
    public ResponseEntity<SaleDto> findById(Integer id) {
        return ResponseEntity.ok(saleService.findById(id));
    }

    @Override
    public ResponseEntity<SaleDto> findSaleCode(String saleCode) {
        return ResponseEntity.ok(saleService.findByCode(saleCode));
    }

    @Override
    public ResponseEntity<List<SaleDto>> findAll() {
        return ResponseEntity.ok(saleService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        saleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
