package com.informatorio.Carrito.service;

import com.informatorio.Carrito.entity.User;
import com.informatorio.Carrito.repository.UserRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) { 
        this.userRepository = userRepository; 
    }

    public User createUser(User newUser) { 
        return userRepository.save(newUser); 
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long userId) {
        return userRepository.getUserById(userId);
    }
    
    public void deleteUser(User userDelete) {
        userRepository.delete(userDelete);
    }
    
    public User updateUser(User user, User userToUpdate) {
       user.setName(userToUpdate.getName());
       user.setLastName(userToUpdate.getLastName());
       user.setEmail(userToUpdate.getEmail());
       user.setPassword(userToUpdate.getPassword());
       user.setCountry(userToUpdate.getCountry());
       user.setCity(userToUpdate.getCity());
       user.setState(userToUpdate.getState());
       user.setEmployee(userToUpdate.isEmployee());
       return userRepository.save(user);
       
    }
    
    public List<User> userByCity(String name) { 
        return userRepository.findUserByCity(name); 
    }

    public List<User> findCreationDateAfter(LocalDate date) {
        return userRepository.findCreationDateAfter(date);
    }
}
