package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.LineSaleDto;
import com.nde.shopmanagement.dto.SaleDto;
import com.nde.shopmanagement.dto.SupplierOrderDto;
import com.nde.shopmanagement.entities.Item;
import com.nde.shopmanagement.entities.LineSale;
import com.nde.shopmanagement.entities.Sale;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.ItemRepository;
import com.nde.shopmanagement.repositories.LineSaleRepository;
import com.nde.shopmanagement.repositories.SaleRepository;
import com.nde.shopmanagement.services.SaleService;
import com.nde.shopmanagement.validators.SaleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SaleServiceImpl implements SaleService {

    private ItemRepository itemRepository;
    private SaleRepository saleRepository;
    private LineSaleRepository lineSaleRepository;

    public SaleServiceImpl(ItemRepository itemRepository,
                           SaleRepository saleRepository,
                           LineSaleRepository lineSaleRepository) {
        this.itemRepository = itemRepository;
        this.saleRepository = saleRepository;
        this.lineSaleRepository = lineSaleRepository;
    }

    @Override
    public SaleDto save(SaleDto saleDto) {
        List<String> errors = SaleValidator.validate(saleDto);
        if (!errors.isEmpty()){
            log.error("Sale is not valid");
            throw new InvalidEntityException("", ErrorCodes.SALE_NOT_VALID, errors);
        }
        List<String> itemErrors = new ArrayList<>();
        saleDto.getLineSale().forEach(lineSaleDto -> {
            Optional<Item> item = itemRepository.findById(lineSaleDto.getItem().getId());
            if(item.isEmpty()){
                itemErrors.add("No item found with ID " + lineSaleDto.getItem().getId());
            }
        });

        if (!itemErrors.isEmpty()) {
            log.error("One or more items were not found, {}", errors);
            throw new InvalidEntityException("No items found", ErrorCodes.SALE_NOT_FOUND);
        }

        Sale savedSale = saleRepository.save(SaleDto.toEntity(saleDto));

        saleDto.getLineSale().forEach(lineSaleDto -> {
            LineSale lineSale = LineSaleDto.toEntity(lineSaleDto);
            lineSale.setSale(savedSale);
            lineSaleRepository.save(lineSale);
        });
        return SaleDto.fromEntity(savedSale);
    }

    @Override
    public SaleDto findById(Integer id) {
        if (id == null){
            log.error("Sale ID is NULL");
            return null;
        }
        return saleRepository.findById(id)
                .map(SaleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No sale was found", ErrorCodes.SALE_NOT_FOUND));
    }

    @Override
    public SaleDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Sale code is NULL");
            return null;
        }
        return saleRepository.findByCode(code)
                .map(SaleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No sale found with CODE "+ code, ErrorCodes.SALE_NOT_FOUND
                ));
    }

    @Override
    public List<SaleDto> findAll() {
        return saleRepository.findAll()
                .stream().map(SaleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Sale ID is NULL");
            return;
        }
        saleRepository.deleteById(id);
    }
}
