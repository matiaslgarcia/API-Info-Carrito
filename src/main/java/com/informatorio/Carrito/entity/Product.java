package com.informatorio.Carrito.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ingreso de Nombre del Producto obligatorio")
    @Column(nullable = false)
    private String nameProduct;
    
    @NotBlank(message = "Ingreso de Descripcion del Producto obligatorio")
    @Column(nullable = false)
    private String descriptionProduct;
   
    @Column(nullable = false)
    private double priceUnitProduct;
  
    @NotBlank(message = "Ingreso de contenido del Producto obligatorio")
    @Column(nullable = false)
    private String contentProduct;
    
    private LocalDate createDateProduct = LocalDate.now();
    
    private boolean publicateProduct = true;
    
    
}
