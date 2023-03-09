package com.example.coffee_shop.service;


import ch.qos.logback.core.model.Model;
import com.example.coffee_shop.entity.*;
import com.example.coffee_shop.repository.OrderRepo;
import com.example.coffee_shop.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private CategoryServiceImpl categoryService;
    private OrderRepo orderRepo;
    private UserServiceImpl userService;
    private AllOrders allOrders;
    private LoggedUser loggedUser;
    private ModelMapper mapper=new ModelMapper();

    public OrderServiceImpl(CategoryServiceImpl categoryService, OrderRepo orderRepo, UserServiceImpl userService, AllOrders allOrders) {
        this.categoryService = categoryService;
        this.orderRepo=orderRepo;
        this.userService = userService;
        this.allOrders = allOrders;
    }
    @Override
    public void addOrder(OrderDto productDto) {
        Order product=new Order();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setOrderTime(productDto.getOrderTime());
        product.setCategory(this.categoryService.findByName(CategoryName.valueOf(productDto.getCategoryName())).get());
        product.setDescription(productDto.getDescription());
        product.setEmployee(mapper.map(loggedUser,User.class));
        this.orderRepo.save(product);
    }
    @Override
    public Order findOrderByName(String name) {
        return this.orderRepo.findProductByName(name);
    }

    @Override
    public List<Order> allOrders() {
        List<Order> food = this.orderRepo.findAll();
        allOrders.setFood(food);
        return food;
    }

    @Override
    public void delete(Long id) {
        this.orderRepo.deleteById(id);
    }

    @Override
    public Order findTheProductThatIsGoingToBeBuyed(Long id) {
        return this.orderRepo.findById(id).orElse(null);
    }

}
