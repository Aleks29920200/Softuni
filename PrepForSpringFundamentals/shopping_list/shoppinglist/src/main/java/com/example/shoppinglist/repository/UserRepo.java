package com.example.shoppinglist.repository;



import com.example.shoppinglist.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);
    User findUserByEmail(String email);
}

