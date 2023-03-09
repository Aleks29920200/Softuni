package com.example.coffee_shop.controller;


import com.example.coffee_shop.entity.Order;
import com.example.coffee_shop.service.OrderServiceImpl;
import com.example.coffee_shop.service.UserServiceImpl;
import com.example.coffee_shop.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Home {
    private LoggedUser loggedUser;
    private ModelMapper mapper=new ModelMapper();
    private UserServiceImpl userService;
    private OrderServiceImpl orderService;


    public Home(LoggedUser loggedUser , UserServiceImpl userService, OrderServiceImpl orderService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.orderService = orderService;
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/")
    public String postIndex() {
        return "redirect:/index";
    }
    @GetMapping("/home")
    public String home(Model model){
        List<Order> drinks = orderService.allOrders();
        model.addAttribute("drinks",drinks);
        return "home";
    }
    @GetMapping("buy/{id}")
    public String delete(@PathVariable Long id){
        Order product = this.orderService.findTheProductThatIsGoingToBeBuyed(id);
        this.orderService.delete(product.getId());
        return "redirect:/home";
    }
}
