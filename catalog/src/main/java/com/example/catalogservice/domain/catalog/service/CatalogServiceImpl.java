package com.example.catalogservice.domain.catalog.service;

import com.example.catalogservice.domain.catalog.dto.response.CatalogResponseDto;
import com.example.catalogservice.domain.catalog.entity.CatalogEntity;
import com.example.catalogservice.domain.catalog.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;
    @Override
    public List<CatalogResponseDto> getAllCatalogs() {
        List<CatalogEntity> catalogEntityList = catalogRepository.findAll();

        return catalogEntityList.stream().map(CatalogResponseDto::new).collect(Collectors.toList());
    }
}
