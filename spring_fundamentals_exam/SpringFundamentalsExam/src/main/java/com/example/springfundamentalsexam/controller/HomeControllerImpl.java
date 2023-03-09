package com.example.springfundamentalsexam.controller;



import com.example.springfundamentalsexam.domain.dto.OfferDto;
import com.example.springfundamentalsexam.domain.entity.Offer;
import com.example.springfundamentalsexam.domain.entity.User;
import com.example.springfundamentalsexam.repository.OfferRepo;
import com.example.springfundamentalsexam.service.HomeServiceImpl;
import com.example.springfundamentalsexam.service.OfferServiceImpl;
import com.example.springfundamentalsexam.service.UserServiceImpl;
import com.example.springfundamentalsexam.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
public class HomeControllerImpl implements HomeController{
    private LoggedUser loggedUser;
    private ModelMapper mapper=new ModelMapper();
    private UserServiceImpl userService;
    private OfferServiceImpl offerService;
    private HomeServiceImpl homeService;
    private OfferRepo offerRepo;


    public HomeControllerImpl(LoggedUser loggedUser , UserServiceImpl userService, OfferServiceImpl offerService, HomeServiceImpl homeService, OfferRepo offerRepo) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.offerService = offerService;
        this.homeService = homeService;
        this.offerRepo = offerRepo;
    }
    @Override
    public String index() {
        return "index";
    }
    @Override
    public String postIndex() {
        return "redirect:/index";
    }
    @Override
    public String home(Model model){
        if(loggedUser.getUsername()==null||loggedUser.getPassword()==null) {
           return "redirect:/";
        }
        User user = this.userService.findUserByUsername(loggedUser.getUsername()).get();
        List<Offer> offers = user.getOffers();
        model.addAttribute("offers", offers);
            List<Offer> otherOffers = user.getBoughtOffers();
            model.addAttribute("otherOffers", otherOffers);
            List<Offer> userBoughtOffers = user.getBoughtOffers();
            model.addAttribute("boughtOffers", userBoughtOffers);
        return "home";
    }
    @Override
    public String buy(@PathVariable Long id){
        this.homeService.buyOffer(id);
        return "redirect:/home";
    }
    @Override
    public String remove(@PathVariable Long id){
        this.homeService.removeOffer(id);
        return "redirect:/home";
    }

}
