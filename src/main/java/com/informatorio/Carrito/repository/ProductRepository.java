package com.informatorio.Carrito.repository;

import com.informatorio.Carrito.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{

    public Product getProductById(Long productId);
    
    
}
