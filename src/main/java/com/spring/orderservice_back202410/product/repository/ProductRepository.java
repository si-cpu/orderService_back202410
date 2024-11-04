package com.spring.orderservice_back202410.product.repository;


import com.spring.orderservice_back202410.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

}