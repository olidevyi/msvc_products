package com.olidev.pe.msvc_products.repositories;

import com.olidev.pe.msvc_products.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
