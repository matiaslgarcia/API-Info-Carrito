package com.informatorio.Carrito.controller;

import com.informatorio.Carrito.entity.Product;
import com.informatorio.Carrito.entity.User;
import com.informatorio.Carrito.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    
    /* controler -> service -> repository  */
    @Autowired
    private ProductService productService;
    
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product newProduct){
        return new ResponseEntity<> (productService.createProduct(newProduct), HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }
    
    @GetMapping(value="/{id}")
    public Product findProductById(@PathVariable("id") Long productId){
        return productService.findProductById(productId);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteProductById(@PathVariable("id") Long productId){
        Product productDelete = productService.findProductById(productId);
        productService.deleteProduct(productDelete);
    }
    
    @PutMapping(value = "/{id}")
    public Product updateProductById(@PathVariable("id") Long productId, @RequestBody Product productToUpdate){
        Product product = productService.findProductById(productId);
        return productService.updateProduct(product ,productToUpdate);
    }
}
