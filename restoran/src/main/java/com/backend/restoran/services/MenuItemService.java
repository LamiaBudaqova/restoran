package com.backend.restoran.services;

import com.backend.restoran.dtos.request.MenuItemRequestDto;
import com.backend.restoran.dtos.response.MenuItemResponseDto;

import java.util.List;

public interface MenuItemService {
    List<MenuItemResponseDto> getAll();
    MenuItemResponseDto getById(Long id);
    MenuItemResponseDto create(MenuItemRequestDto request);
    MenuItemResponseDto update(Long id, MenuItemRequestDto request);
    void delete(Long id);
}
