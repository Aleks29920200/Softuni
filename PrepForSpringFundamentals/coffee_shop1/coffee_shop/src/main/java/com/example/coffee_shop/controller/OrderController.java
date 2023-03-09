package com.example.coffee_shop.controller;


import com.example.coffee_shop.entity.OrderDto;
import com.example.coffee_shop.service.OrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {
private OrderServiceImpl productService;

    public OrderController(OrderServiceImpl productService) {
        this.productService = productService;
    }
    @GetMapping("/addOrder")
    public String addSong(){
        return "order-add";
    }
    @PostMapping("/addOrder")
    public String addSongPost(@Valid @ModelAttribute OrderDto orderDto, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            attr
                    .addFlashAttribute("orderDto", orderDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderDto", result);

            return "redirect:/addOrder";
        }
        this.productService.addOrder(orderDto);
        return "redirect:/home";
    }
     @ModelAttribute
    public OrderDto productDto() {
        return new OrderDto();
    }

}
