package com.example.spotifyplaylistapp.repository;



import com.example.spotifyplaylistapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);
    User findUserByEmail(String email);
}

