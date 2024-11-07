package com.olidev.pe.msvc_products.services;

import com.olidev.pe.msvc_products.entities.Product;
import com.olidev.pe.msvc_products.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final Environment environment; // NUEVO PARA EL BALANCEADOR DE CARGAS

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return ( (List<Product>) productRepository.findAll() ).stream().map(product -> {
            // NUEVO PARA EL BALANCEADOR DE CARGAS
            product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return product;
        }).collect(Collectors.toList()); // FIN BALANCEADOR DE CARGAS
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(long id) {
        // NUEVO PARA EL BALANCEADOR DE CARGAS
        return productRepository.findById(id).map(product -> {
            product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return product; // FIN BALANCEADOR DE CARGAS
        });
    }
}
