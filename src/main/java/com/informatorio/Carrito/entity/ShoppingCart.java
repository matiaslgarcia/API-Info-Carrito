package com.informatorio.Carrito.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class ShoppingCart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private CategoryMovil generateBy;
     
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id", nullable = false)
//    @JsonBackReference(value="shoppingCartReference")
//    private User user;
     
    private LocalDate creationDate = LocalDate.now();
    
    @Transient
    private double totalCart;
    
   
    
//    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference(value="shoppingProduct")
//    private List<Product> products = new ArrayList<>();
    
}
