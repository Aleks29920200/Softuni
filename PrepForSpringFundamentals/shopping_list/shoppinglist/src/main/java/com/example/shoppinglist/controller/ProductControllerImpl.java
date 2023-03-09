package com.example.shoppinglist.controller;


import com.example.shoppinglist.domain.dto.ProductDto;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductControllerImpl implements ProductController {
private ProductService productService;
private LoggedUser user;

    public ProductControllerImpl(ProductService productService, LoggedUser user) {
        this.productService = productService;
        this.user = user;
    }

    @Override
    public String addSong(){
        if(user.getUsername()==null||user.getPassword()==null) {
            return "redirect:/";
        }
        return "product-add";
    }
    @Override
    public String addSongPost(@Valid ProductDto productDto, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            attr
                    .addFlashAttribute("productDto", productDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productDto", result);

            return "redirect:/addProduct";
        }
        this.productService.addProduct(productDto);
        return "redirect:/home";
    }
     @ModelAttribute
    public ProductDto productDto() {
        return new ProductDto();
    }

}
