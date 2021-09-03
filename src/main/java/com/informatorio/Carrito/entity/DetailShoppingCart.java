package com.informatorio.Carrito.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DetailShoppingCart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="product_id", nullable = false)
//    @JsonBackReference(value="productReference")
//    private Product product;
    
    private int count;
    
    @Transient
    public double getSubTotal() {
        return product.getPriceUnitProducit()*count;
    }
}

