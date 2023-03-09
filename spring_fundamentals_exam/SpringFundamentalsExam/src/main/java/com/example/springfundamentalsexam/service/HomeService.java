package com.example.springfundamentalsexam.service;

import com.example.springfundamentalsexam.domain.dto.OfferDto;
import com.example.springfundamentalsexam.domain.entity.Offer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeService {
    void buyOffer(Long id);

    void removeOffer(Long id);

}
