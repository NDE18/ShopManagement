package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.SupplierOrderDto;
import com.nde.shopmanagement.dto.SupplierOrderLineDto;
import com.nde.shopmanagement.entities.*;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.ItemRepository;
import com.nde.shopmanagement.repositories.SupplierOrderLineRepository;
import com.nde.shopmanagement.repositories.SupplierOrderRepository;
import com.nde.shopmanagement.repositories.SupplierRepository;
import com.nde.shopmanagement.services.SupplierOrderService;
import com.nde.shopmanagement.validators.SupplierOrderValidator;
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
public class SupplierOrderServiceImpl implements SupplierOrderService {

    private SupplierRepository supplierRepository;
    private SupplierOrderRepository supplierOrderRepository;
    private SupplierOrderLineRepository supplierOrderLineRepository;
    private ItemRepository itemRepository;

    @Autowired
    public SupplierOrderServiceImpl(SupplierRepository supplierRepository,
                                    SupplierOrderRepository supplierOrderRepository,
                                    SupplierOrderLineRepository supplierOrderLineRepository,
                                    ItemRepository itemRepository) {
        this.supplierRepository = supplierRepository;
        this.supplierOrderRepository = supplierOrderRepository;
        this.supplierOrderLineRepository = supplierOrderLineRepository;
        this.itemRepository = itemRepository;
    }


    @Override
    public SupplierOrderDto save(SupplierOrderDto supplierOrderDto) {
        List<String> errors = SupplierOrderValidator.validate(supplierOrderDto);
        if (!errors.isEmpty()){
            log.error("Supplier order is not valid");
            throw new InvalidEntityException("Supplier order is not valid", ErrorCodes.SUPPLIER_ORDER_NOT_VALID);
        }

        Optional<Supplier> supplier = supplierRepository.findById(supplierOrderDto.getSupplier().getId());
        if (!supplier.isPresent()){
            log.warn("Supplier with ID {} not found", supplierOrderDto.getSupplier().getId());
            throw new EntityNotFoundException("No supplier with ID {} has been found",ErrorCodes.SUPPLIER_ORDER_NOT_FOUND);
        }

        List<String> itemErrors = new ArrayList<>();

        if (supplierOrderDto.getSupplierOrderLines() != null){
            supplierOrderDto.getSupplierOrderLines().forEach(linOrSup -> {
                if (linOrSup.getItem() != null){
                    Optional<Item> item = itemRepository.findById(linOrSup.getItem().getId());
                    if (item.isEmpty()){
                        itemErrors.add("Supplier with ID {}" + linOrSup.getItem().getId() + " not found");
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

        SupplierOrder savedSupOrder = supplierOrderRepository.save(SupplierOrderDto.toEntity(supplierOrderDto));

        if (supplierOrderDto.getSupplierOrderLines() != null){
            supplierOrderDto.getSupplierOrderLines().forEach(linSupOrder -> {
                SupplierOrderLine supplierOrderLine = SupplierOrderLineDto.toEntity(linSupOrder);
                supplierOrderLine.setSupplierOrder(savedSupOrder);
                supplierOrderLineRepository.save(supplierOrderLine);
            });
        }

        return SupplierOrderDto.fromEntity(savedSupOrder);
    }

    @Override
    public SupplierOrderDto findById(Integer id) {
        if (id == null){
            log.error("Supplier order ID is null");
            return null;
        }

        return supplierOrderRepository.findById(id)
                .map(SupplierOrderDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No supplier order found with ID "+ id, ErrorCodes.SUPPLIER_ORDER_NOT_FOUND
                ));
    }

    @Override
    public SupplierOrderDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Customer order code is NULL");
            return null;
        }
        return supplierOrderRepository.findByCode(code)
                .map(SupplierOrderDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No supplier order found with CODE "+ code, ErrorCodes.SUPPLIER_ORDER_NOT_FOUND
                ));
    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return supplierOrderRepository.findAll()
                .stream().map(SupplierOrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        supplierOrderRepository.deleteById(id);
    }
}
