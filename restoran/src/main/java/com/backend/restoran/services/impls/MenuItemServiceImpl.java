package com.backend.restoran.services.impls;

import com.backend.restoran.dtos.request.MenuItemRequestDto;
import com.backend.restoran.dtos.response.MenuItemResponseDto;
import com.backend.restoran.models.Category;
import com.backend.restoran.models.MenuItem;
import com.backend.restoran.repositories.CategoryRepository;
import com.backend.restoran.repositories.MenuItemRepository;
import com.backend.restoran.services.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<MenuItemResponseDto> getAll() {
        return menuItemRepository.findAll()
                .stream()
                .map(menuItem -> {
                    MenuItemResponseDto dto = modelMapper.map(menuItem, MenuItemResponseDto.class);
                    dto.setCategoryName(menuItem.getCategory().getName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public MenuItemResponseDto getById(Long id) {
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yemək tapılmadı"));
        MenuItemResponseDto dto = modelMapper.map(item, MenuItemResponseDto.class);
        dto.setCategoryName(item.getCategory().getName());
        return dto;
    }

    @Override
    public MenuItemResponseDto create(MenuItemRequestDto request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Kateqoriya tapılmadı"));

        MenuItem item = new MenuItem();
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setPrice(request.getPrice());
        item.setImageUrl(request.getImageUrl());
        item.setCategory(category);

        MenuItem saved = menuItemRepository.save(item);

        MenuItemResponseDto dto = modelMapper.map(saved, MenuItemResponseDto.class);
        dto.setCategoryName(category.getName());
        return dto;
    }

    @Override
    public MenuItemResponseDto update(Long id, MenuItemRequestDto request) {
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Yemək tapılmadı"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Kateqoriya tapılmadı"));

        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setPrice(request.getPrice());
        item.setImageUrl(request.getImageUrl());
        item.setCategory(category);

        MenuItem updated = menuItemRepository.save(item);

        MenuItemResponseDto dto = modelMapper.map(updated, MenuItemResponseDto.class);
        dto.setCategoryName(category.getName());
        return dto;
    }

    @Override
    public void delete(Long id) {
        menuItemRepository.deleteById(id);
    }
}
