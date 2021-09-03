package com.informatorio.Carrito.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @OneToOne(mappedBy="shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference(value="shoppingCartReference")
//    private List <ShoppingCart> shoopingCarts = new ArrayList<>();
    
    private LocalDate registerDate = LocalDate.now();
    
    @Size(max=200)
    private String observations;
    
//    @OneToOne(mappedBy="purchases", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference(value="userReference")
//    private List <User> userPurchase = new ArrayList<>();
}
