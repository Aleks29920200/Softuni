package com.example.springfundamentalsexam.controller;



import com.example.springfundamentalsexam.domain.dto.OfferDto;
import com.example.springfundamentalsexam.service.OfferService;
import com.example.springfundamentalsexam.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferControllerImpl implements OfferController {
private OfferService offerService;
private LoggedUser user;

    public OfferControllerImpl(OfferService offerService, LoggedUser user) {
        this.offerService = offerService;
        this.user = user;
    }

    @Override
    public String addSong(){
        if(user.getUsername()==null||user.getPassword()==null) {
            return "redirect:/";
        }
        return "offer-add";
    }
    @Override
    public String addSongPost(@Valid OfferDto offerDto, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            attr
                    .addFlashAttribute("offerDto", offerDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerDto", result);

            return "redirect:/addOffer";
        }
        this.offerService.addOffer(offerDto);
        return "redirect:/home";
    }
     @ModelAttribute
    public OfferDto productDto() {
        return new OfferDto();
    }

}
