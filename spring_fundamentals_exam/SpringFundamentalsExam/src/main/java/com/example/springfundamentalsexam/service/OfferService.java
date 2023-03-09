package com.example.springfundamentalsexam.service;


import com.example.springfundamentalsexam.domain.dto.OfferDto;
import com.example.springfundamentalsexam.domain.entity.Offer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface OfferService {
void addOffer(OfferDto offer);

    void delete(Long id);
    Optional<Offer> findOfferById(Long id);

    List<OfferDto> allOffers();
}
