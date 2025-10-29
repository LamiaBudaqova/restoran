package com.backend.restoran.controllers;

import com.backend.restoran.dtos.request.MenuItemRequestDto;
import com.backend.restoran.dtos.response.MenuItemResponseDto;
import com.backend.restoran.services.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/menu-items")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping
    public MenuItemResponseDto create(@RequestBody MenuItemRequestDto request){
        return menuItemService.create(request);
    }

    @PutMapping("/{id}")
    public MenuItemResponseDto update(@PathVariable Long id, @RequestBody MenuItemRequestDto request){
        return menuItemService.update(id, request);
    }

    @GetMapping("/{id}")
    public MenuItemResponseDto getById(@PathVariable Long id){
        return menuItemService.getById(id);
    }

    @GetMapping
    public List<MenuItemResponseDto> getAll(){
        return menuItemService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        menuItemService.delete(id);
    }
}
