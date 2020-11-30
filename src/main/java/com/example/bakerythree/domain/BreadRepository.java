package com.example.bakerythree.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BreadRepository extends CrudRepository<Bread, Long> {
    Bread findAllById(Long id);

    Bread findByName(@Param("name") String name);

    List<Bread> findByBrand(@Param("Brand") String brand);
}
