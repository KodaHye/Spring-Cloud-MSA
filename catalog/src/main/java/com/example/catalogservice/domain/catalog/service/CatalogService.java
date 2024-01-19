package com.example.catalogservice.domain.catalog.service;

import com.example.catalogservice.domain.catalog.dto.response.CatalogResponseDto;

import java.util.List;

public interface CatalogService {
    List<CatalogResponseDto> getAllCatalogs();
}
