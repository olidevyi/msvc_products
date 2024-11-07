package com.olidev.pe.msvc_products.services;

import com.olidev.pe.msvc_products.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(long id);
}
