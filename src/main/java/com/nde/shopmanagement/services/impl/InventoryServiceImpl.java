package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.InventoryDto;
import com.nde.shopmanagement.dto.SupplierDto;
import com.nde.shopmanagement.entities.Inventory;
import com.nde.shopmanagement.entities.Supplier;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.InventoryRepository;
import com.nde.shopmanagement.services.InventoryService;
import com.nde.shopmanagement.validators.InventoryValidator;
import com.nde.shopmanagement.validators.SupplierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public InventoryDto save(InventoryDto inventoryDto) {
        List<String> errors = InventoryValidator.validate(inventoryDto);
        if (errors.isEmpty()){
            log.error("Item is not valid {}", inventoryDto);
            throw new InvalidEntityException("Inventory is not valid", ErrorCodes.INVENTORY_NOT_VALID, errors);
        }
        return InventoryDto.fromEntity(inventoryRepository.save(InventoryDto.toEntity(inventoryDto)));
    }

    @Override
    public InventoryDto findById(Integer id) {
        if(id == null){
            log.error("ID inventory is null {}", id);
        }
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        InventoryDto inventoryDto = InventoryDto.fromEntity(inventory.get());

        return Optional.of(inventoryDto).orElseThrow(() -> new EntityNotFoundException(
                "No inventory with ID = "+id+" found.",
                ErrorCodes.INVENTORY_NOT_FOUND
        ));
    }

    @Override
    public List<InventoryDto> findAll() {
        return inventoryRepository.findAll()
                .stream().map(InventoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        inventoryRepository.deleteById(id);
    }
}
