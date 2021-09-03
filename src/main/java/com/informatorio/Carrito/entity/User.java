package com.informatorio.Carrito.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Entity 
@Data   //Genera los correspondientes getters and setters
@NoArgsConstructor //Crea un constructor sin argumentos
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ingreso de Nombre obligatorio")
    private String name;

    @NotBlank(message = "Ingreso de Apellido obligatorio")
    private String lastName;
    
    @NotBlank(message = "Ingreso de Email obligatorio")
    @Column(unique = true, nullable = false)
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;
    
    @NotBlank(message = "Ingreso de Password obligatorio")
    @Size(min = 8, max = 20, message = "La contraseña debe contener como minimo 8 caracteres y maximo 20")
    @Value("${db.password}")
    private String password;

    private LocalDate registerDate = LocalDate.now();
    
    private String country;
    private String state;
    private String city;
    
    @Value("false")
    private boolean employee;

//    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference(value="shoppingCartReference")
//    private List <ShoppingCart> shoopingCarts = new ArrayList<>();

//    @OneToMany(mappedBy="userPurchase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference(value="purchaseUser")
//    private List <Purchase> purchases = new ArrayList<>();

   
}
