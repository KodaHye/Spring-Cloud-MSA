package com.example.catalogservice.domain.catalog.dto.response;

import com.example.catalogservice.domain.catalog.entity.CatalogEntity;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class CatalogResponseDto implements Serializable {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private LocalDateTime createdAt;

    public CatalogResponseDto(CatalogEntity catalog) {
        this.productId = catalog.getProductId();
        this.productName = catalog.getProductName();
        this.unitPrice = catalog.getUnitPrice();
        this.stock = catalog.getStock();
        this.createdAt = catalog.getCreatedAt();
    }
}
