package com.example.springfundamentalsexam.repository;


import com.example.springfundamentalsexam.domain.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Long> {
    Optional<Offer> findOfferById(Long id);
}
