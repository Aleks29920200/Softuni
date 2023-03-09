package com.example.springfundamentalsexam.service;


import com.example.springfundamentalsexam.domain.dto.OfferDto;
import com.example.springfundamentalsexam.domain.entity.Offer;
import com.example.springfundamentalsexam.domain.entity.User;
import com.example.springfundamentalsexam.domain.enums.ConditionName;
import com.example.springfundamentalsexam.repository.OfferRepo;
import com.example.springfundamentalsexam.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private ConditionServiceImpl conditionService;
    private OfferRepo offerRepo;
    private UserServiceImpl userService;
    private ModelMapper mapper;
    private LoggedUser loggedUser;
    private List<Offer>offers=new ArrayList<>();

    public OfferServiceImpl(ConditionServiceImpl conditionService, OfferRepo offerRepo, UserServiceImpl userService, ModelMapper mapper, LoggedUser loggedUser) {
        this.conditionService = conditionService;
        this.offerRepo = offerRepo;
        this.userService = userService;
        this.mapper = mapper;
        this.loggedUser = loggedUser;
    }
    @Override
    public void addOffer(OfferDto offerDto) {
        Offer offer=new Offer();
        offer.setDescription(offerDto.getDescription());
        offer.setPrice(offerDto.getPrice());
        offer.setCondition(this.conditionService.findByConditionName(ConditionName.valueOf(offerDto.getConditionName())));
        User user = this.userService.findUserByUsername(loggedUser.getUsername()).get();
        user.getOffers().add(offer);
        this.offerRepo.save(offer);
    }
    @Override
    public void delete(Long id) {
        this.offerRepo.deleteById(id);
    }

    @Override
    public Optional<Offer> findOfferById(Long id) {
        return Optional.ofNullable(this.offerRepo.findOfferById(id).orElse(null));
    }

    @Override
    public List<OfferDto> allOffers() {
        return this.offerRepo.findAll().stream().map(e->mapper.map(e,OfferDto.class)).collect(Collectors.toList());
    }
}
