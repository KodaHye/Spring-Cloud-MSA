package com.example.catalogservice.domain.catalog.controller;

import com.example.catalogservice.domain.catalog.dto.response.CatalogResponseDto;
import com.example.catalogservice.domain.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog-service")
public class CatalogController {
    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<List<CatalogResponseDto>> getCatalogs() {
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.getAllCatalogs());
    }
}
