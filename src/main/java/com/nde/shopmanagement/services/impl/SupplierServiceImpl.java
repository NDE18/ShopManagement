package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.SupplierDto;
import com.nde.shopmanagement.entities.Supplier;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.SupplierRepository;
import com.nde.shopmanagement.services.SupplierService;
import com.nde.shopmanagement.validators.SupplierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierDto save(SupplierDto supplierDto) {
        List<String> errors = SupplierValidator.validate(supplierDto);
        if (errors.isEmpty()){
            log.error("Item is not valid {}", supplierDto);
            throw new InvalidEntityException("Item is not valid", ErrorCodes.SUPPLIER_NOT_FOUND, errors);
        }
        return SupplierDto.fromEntity(supplierRepository.save(SupplierDto.toEntity(supplierDto)));
    }

    @Override
    public SupplierDto findById(Integer id) {
        if(id == null){
            log.error("ID supplier is null {}", id);
        }
        Optional<Supplier> supplier = supplierRepository.findById(id);
        SupplierDto supplierDto = SupplierDto.fromEntity(supplier.get());

        return Optional.of(supplierDto).orElseThrow(() -> new EntityNotFoundException(
                "No supplier with ID = "+id+" found.",
                ErrorCodes.SUPPLIER_NOT_FOUND
        ));
    }

    @Override
    public SupplierDto findSupplierCode(String itemCode) {
        return null;
    }

    @Override
    public List<SupplierDto> findAll() {
        return supplierRepository.findAll()
                .stream().map(SupplierDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        supplierRepository.deleteById(id);
    }
}
