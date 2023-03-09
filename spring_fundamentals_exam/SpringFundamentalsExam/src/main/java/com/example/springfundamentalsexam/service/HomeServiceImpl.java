package com.example.springfundamentalsexam.service;

import com.example.springfundamentalsexam.domain.dto.OfferDto;
import com.example.springfundamentalsexam.domain.entity.Offer;
import com.example.springfundamentalsexam.domain.entity.User;
import com.example.springfundamentalsexam.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {
    private UserServiceImpl userService;
    private OfferServiceImpl offerService;
    private LoggedUser loggedUser;
    private ModelMapper mapper;

    public HomeServiceImpl(UserServiceImpl userService, OfferServiceImpl offerService, LoggedUser loggedUser, ModelMapper mapper) {
        this.userService = userService;
        this.offerService = offerService;
        this.loggedUser = loggedUser;
        this.mapper = mapper;
    }

    @Override
    public void buyOffer(Long id) {
        Optional<OfferDto> offerById = this.offerService.findOfferById(id).map(e->mapper.map(e, OfferDto.class));
        this.userService.findUserByUsername(loggedUser.getUsername()).get().getBoughtOffers().add(mapper.map(offerById,Offer.class));
    }
    @Override
    public void removeOffer(Long id) {
        this.offerService.delete(id);
    }


    /*@Override
    public List<OfferDto> allOffersBoughtByCurrentUser() {
        return this.userService.findUserByUsername(loggedUser.getUsername()).get().getBoughtOffers().stream().map(e->mapper.map(e,OfferDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<OfferDto> otherOffers() {
        List<User> otherUsers = this.userService.allUsers().stream().filter(e -> !(e.getUsername().equals(loggedUser.getUsername()))).toList();
        List<OfferDto>otherOffers= otherUsers.stream().map(User::getOffers).flatMap(Collection::stream).toList().stream().map(e->mapper.map(e,OfferDto.class)).collect(Collectors.toList());
        return otherOffers;
    }
    */
}
