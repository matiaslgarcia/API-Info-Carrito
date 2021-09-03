package com.informatorio.Carrito.repository;

import com.informatorio.Carrito.entity.User;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User getUserById(Long id);
    
     @Query("FROM User WHERE city LIKE ?1")
    List <User> findUserByCity(String cityName);

    @Query("FROM User WHERE registerDate > ?1")
    List <User> findCreationDateAfter(LocalDate date);
}
