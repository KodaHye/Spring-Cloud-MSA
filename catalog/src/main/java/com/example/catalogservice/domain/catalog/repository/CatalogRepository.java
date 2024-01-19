package com.example.catalogservice.domain.catalog.repository;

import com.example.catalogservice.domain.catalog.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogEntity, Integer> {
}
