package com.example.coffee_shop.repository;



import com.example.coffee_shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);
    User findUserByEmail(String email);
}

