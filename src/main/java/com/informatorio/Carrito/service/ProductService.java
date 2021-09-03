package com.informatorio.Carrito.service;

import com.informatorio.Carrito.entity.Product;
import com.informatorio.Carrito.entity.User;
import com.informatorio.Carrito.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    //la injeccion la utilice porque es mas facil ahcer test
    @Autowired          
    private ProductRepository productRepository;

    public Product createProduct(Product newProduct)
    { return productRepository.save(newProduct);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long productId) {
       return productRepository.getProductById(productId);
    }
    
    public void deleteProduct(Product productDelete){
        productRepository.delete(productDelete);
    }
    
    public Product updateProduct(Product product, Product productToUpdate) {
       product.setNameProduct(productToUpdate.getNameProduct());
       product.setDescriptionProduct(productToUpdate.getDescriptionProduct());
       product.setPriceUnitProduct(productToUpdate.getPriceUnitProduct());
       product.setContentProduct(productToUpdate.getContentProduct());
       product.setPublicateProduct(productToUpdate.isPublicateProduct());
       return productRepository.save(product);
       
    }
}
