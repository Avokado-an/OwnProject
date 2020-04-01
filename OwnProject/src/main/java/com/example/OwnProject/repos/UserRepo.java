package com.example.OwnProject.repos;

import com.example.OwnProject.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    //Set<User> findByCurrent(User user);
}
