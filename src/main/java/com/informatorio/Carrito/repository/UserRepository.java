package com.informatorio.Carrito.repository;

import com.informatorio.Carrito.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User getUserById(Long id);
}
