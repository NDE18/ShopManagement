package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.ItemDto;
import com.nde.shopmanagement.entities.Item;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.ItemRepository;
import com.nde.shopmanagement.services.ItemService;
import com.nde.shopmanagement.validators.ItemValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDto save(ItemDto itemDto) {
        List<String> errors = ItemValidator.validate(itemDto);
        if(!errors.isEmpty()){
            log.error("Item is not valid {}", itemDto);
            throw new InvalidEntityException("Item is not valid", ErrorCodes.ITEM_NOT_VALID, errors);
        }
        return ItemDto.fromEntity(itemRepository.save(ItemDto.toEntity(itemDto)));
    }

    @Override
    public ItemDto findById(Integer id) {
        if(id == null){
            log.error("ID item is null {}", id);
            return null;
        }
        Optional<Item> item = itemRepository.findById(id);

        ItemDto itemDto = ItemDto.fromEntity(item.get());
        return Optional.of(itemDto).orElseThrow(() -> new EntityNotFoundException(
                "No item with ID = "+id+" found.",
                ErrorCodes.ITEM_NOT_FOUND
        ));
    }

    @Override
    public ItemDto findItemCode(String itemCode) {
        if(!StringUtils.hasLength(itemCode)){
            log.error("CODE item is null {}", itemCode);
            return null;
        }
        Optional<Item> item = itemRepository.findItemByCodeItem(itemCode);

        ItemDto itemDto = ItemDto.fromEntity(item.get());
        return Optional.of(itemDto).orElseThrow(() -> new EntityNotFoundException(
                "No item with ID = "+itemCode+" found.",
                ErrorCodes.ITEM_NOT_FOUND
        ));
    }

    @Override
    public List<ItemDto> findAll() {
        return itemRepository.findAll().stream()
                .map(ItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null){
            return;
        }
        itemRepository.deleteById(id);
    }
}
