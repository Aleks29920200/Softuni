package com.example.shoppinglist.controller;


import com.example.shoppinglist.domain.dto.ProductDto;
import com.example.shoppinglist.domain.entity.Product;
import com.example.shoppinglist.service.ProductServiceImpl;
import com.example.shoppinglist.service.UserServiceImpl;
import com.example.shoppinglist.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeControllerImpl implements HomeController{
    private LoggedUser loggedUser;
    private ModelMapper mapper=new ModelMapper();
    private UserServiceImpl userService;
    private ProductServiceImpl productService;


    public HomeControllerImpl(LoggedUser loggedUser , UserServiceImpl userService, ProductServiceImpl productService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.productService = productService;
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
        List<ProductDto> drinks = productService.productsOfDrinkCategory();
        model.addAttribute("drinks", drinks);
        List<ProductDto> food = productService.productsOfFoodCategory();
        model.addAttribute("foods", food);
        List<ProductDto> household = productService.productsOfHouseholdCategory();
        model.addAttribute("household", household);
        List<ProductDto> other = productService.productsOfOtherCategory();
        model.addAttribute("other", other);
        return "home";
    }
    @Override
    public String delete(@PathVariable Long id){
        Product product = this.productService.findTheProductThatIsGoingToBeBuyed(id);
        this.productService.delete(product.getId());
        return "redirect:/home";
    }
    @Override
    public String deleteAll(){
        this.productService.deleteAllProducts();
        return "redirect:/home";
    }
}
